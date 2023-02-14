package com.example.gateway.config;

import com.example.gateway.filter.PostRequestFilter;
import com.example.gateway.filter.PreRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class FilterConfiguration {

    @Autowired
    private GatewayConfig gatewayConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Bean
    public PreRequestFilter preRequestFilter() {
        return new PreRequestFilter(redisTemplate, gatewayConfig);
    }

    @Bean
    public PostRequestFilter postRequestFilter() {
        return new PostRequestFilter();
    }

}