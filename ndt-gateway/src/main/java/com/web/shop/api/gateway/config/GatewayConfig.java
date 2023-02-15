package com.web.shop.api.gateway.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class GatewayConfig {

    @Value("${app.security.expiration-token}")
    private Long expirationToken;

    @Value("${app.security.key-secret}")
    private String keySecret;

    @Value("${app.security.ignore-apis}")
    private String[] ignoreApis;

    @Value("${app.security.authenticate-apis}")
    private String[] authenticateApis;

    @Value("${spring.redis.prefix-key}")
    private String prefixRedisKey;

    @Value("${app.sub-system}")
    private Integer subSystem;

    @Value("${app.time-active-user}")
    private Long timeActiveUser;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;

    @Value("${app.cors.allowed-origins}")
    private String allowedOriginsCors;

    @Value("${app.cors.allowed-methods}")
    private String allowedMethodsCors;

    @Value("${app.cors.allowed-headers}")
    private String allowedHeadersCors;

    @Value("${app.cors.exposed-headers}")
    private String exposedHeadersCors;

    @Value("${app.cors.allow-credentials}")
    private boolean allowCredentialsCors;

    @Value("${app.cors.max-age}")
    private long maxAgeCors;

    @Value("${app.check-spamming-request.enable}")
    private boolean enableCheckSpamming;

    @Value("${app.check-spamming-request.max-request}")
    private long maxRequestCheckSpamming;

    @Value("${app.check-spamming-request.time-for-max-request}")
    private long timeForMaxRequest;

    @Value("${app.check-spamming-request.expiration-time-spamming}")
    private long expirationTimeSpamming;
}
