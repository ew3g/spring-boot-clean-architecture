package com.example.demo.shared.exception;

import lombok.Getter;

@Getter
public class GeneralException extends Exception {
    private final int code;

    public GeneralException(final int code, final String message) {
        super(message);
        this.code = code;
    }
}
