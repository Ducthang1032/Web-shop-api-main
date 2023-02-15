package com.web.shop.api.gateway.config;

import com.web.shop.api.gateway.filter.AuthenticFilter;
import io.github.bucket4j.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GatewayConfig gatewayConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private Bucket bucket;

    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((httpServletRequest, httpServletResponse, e) ->
                        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))
                .and()
                .addFilterAfter(new AuthenticFilter(gatewayConfig, redisTemplate, bucket), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .anyRequest().authenticated();
    }
}
