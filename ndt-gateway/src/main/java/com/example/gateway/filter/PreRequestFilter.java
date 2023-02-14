package com.example.gateway.filter;

import com.example.gateway.config.GatewayConfig;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Zuul filter for restricting access to backend micro-services endpoints.
 */
@RequiredArgsConstructor
@Slf4j
public class PreRequestFilter extends ZuulFilter {

    private final RedisTemplate<String, String> redisTemplate;

    private final GatewayConfig gatewayConfig;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Filter requests on endpoints that are not in the list of authorized microservices endpoints.
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();

            // generate a random request-id
            UUID uuid = UUID.randomUUID();
            ctx.addZuulRequestHeader("request-id", uuid.toString());

            String userId = Objects.toString(
                    ctx.getRequest().getAttribute("UserId"), Strings.EMPTY);

            // get start time
            long startTimeRequest = System.currentTimeMillis();
            ctx.addZuulRequestHeader("start-time-gateway-request", String.valueOf(startTimeRequest));
            ctx.addZuulRequestHeader("userId", userId);

            log.info("Start request-id: {}, method: {}, path: {}",
                    uuid,
                    ctx.getRequest().getMethod(),
                    ctx.getRequest().getRequestURI()
            );
        } catch (Exception e) {
            log.error("Failed when pre request filter", e);
        }
        return null;
    }
}
