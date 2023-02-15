package com.web.shop.api.gateway.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SpammingRequestException extends RuntimeException {

    public SpammingRequestException(final String message) {
        super(message);
    }
}
