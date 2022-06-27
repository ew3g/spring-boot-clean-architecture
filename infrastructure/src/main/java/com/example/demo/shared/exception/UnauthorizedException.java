package com.example.demo.shared.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends GeneralException{

    public UnauthorizedException(final String message) {
        super(HttpStatus.UNAUTHORIZED.value(), message);
    }
}
