package com.example.demo.shared.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BadRequestException extends GeneralException {

    public BadRequestException(final String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
