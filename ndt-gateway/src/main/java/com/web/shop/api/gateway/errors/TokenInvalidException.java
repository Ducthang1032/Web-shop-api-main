package com.web.shop.api.gateway.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class TokenInvalidException extends RuntimeException{
    public TokenInvalidException(final String message) {
        super(message);
    }
}
