package com.example.gateway.filter;

import com.example.gateway.config.GatewayConfig;
import com.example.gateway.dto.TokenInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class AuthenticFilter extends OncePerRequestFilter {
    private final GatewayConfig gatewayConfig;
    private final RedisTemplate<String, String> redisTemplate;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) {
        try {
            String tokenHeader = httpServletRequest.getHeader("Authorization");

            // validate header
            if (StringUtils.isBlank(tokenHeader) || !tokenHeader.startsWith("Bearer ")) {
                log.warn("Stopped request method = {}, URI = {}", httpServletRequest.getMethod(),httpServletRequest.getRequestURI());
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }

            String token = tokenHeader.replace("Bearer ", "");

            //validate token xac thuc
            Claims claims = Jwts.parser().setSigningKey(gatewayConfig.getKeySecret()).parseClaimsJws(token).getBody();
            TokenInfo tokenInfo = (new ObjectMapper().readValue(claims.getSubject(), TokenInfo.class));
            if (Objects.nonNull(tokenInfo) && StringUtils.isNotBlank(tokenInfo.getId()) && StringUtils.isNotBlank(tokenInfo.getUserName())) {
                String tokenSaved = redisTemplate.opsForValue().get(
                        gatewayConfig.getPrefixRedisKey().concat(String.valueOf(tokenInfo.getId()).concat("_")
                                .concat(tokenInfo.getUserName()))
                );
                if (!token.equals(tokenSaved)) {
                    throw new Exception("Unauthorized");
                }
            }
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(tokenInfo.getId(),
                    null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);
            httpServletRequest.setAttribute("UserId", tokenInfo.getId());
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException) {
                httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                httpServletResponse.getWriter().write("Token is expired");
            } else if (e instanceof RuntimeException) {
                httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                httpServletResponse.getWriter().write("Token is invalid");
            }else {
                httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                httpServletResponse.getWriter().write(e.getMessage());
                log.warn("Filter exception", e);
            }
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
