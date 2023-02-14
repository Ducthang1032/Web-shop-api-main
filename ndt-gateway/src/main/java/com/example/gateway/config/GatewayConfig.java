package com.example.gateway.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class GatewayConfig {
    @Value("${app.security.key-secret}")
    private String keySecret;

    @Value("${spring.redis.prefix-key}")
    private String prefixRedisKey;

    @Value("${app.security.expiration-token}")
    private Long expirationToken;
}
