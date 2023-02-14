package com.example.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * Zuul filter for restricting access to backend micro-services endpoints.
 */
@RequiredArgsConstructor
@Slf4j
public class PostRequestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 100;
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
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        Map<String, String> zuulHeaders = RequestContext.getCurrentContext().getZuulRequestHeaders();
        long timeRequest = System.currentTimeMillis() - Long.parseLong(zuulHeaders.get("start-time-gateway-request"));
        log.info("Finish request-id: {}, method: {}, path: {}, time-request: {}ms",
                zuulHeaders.get("request-id"),
                request.getMethod(),
                request.getRequestURI(),
                timeRequest
        );
        return null;
    }
}
