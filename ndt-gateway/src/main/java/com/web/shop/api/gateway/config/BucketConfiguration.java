package com.web.shop.api.gateway.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Getter
@Configuration
public class BucketConfiguration {

    @Value("${app.expiration-time-spamming}")
    private long expirationTimeSpamming;

    @Value("${app.number-of-sent-request}")
    private long numberOfSentRequest;

    @Bean
    public Bucket bucket() {
        Refill refill = Refill.intervally(numberOfSentRequest, Duration.ofSeconds(expirationTimeSpamming));
        Bandwidth limit = Bandwidth.classic(numberOfSentRequest, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }
}
