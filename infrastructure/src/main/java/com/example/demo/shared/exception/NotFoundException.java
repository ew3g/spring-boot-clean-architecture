package com.example.demo.shared.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GeneralException {

    public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
