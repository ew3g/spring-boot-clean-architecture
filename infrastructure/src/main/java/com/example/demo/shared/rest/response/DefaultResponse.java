package com.example.demo.shared.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class DefaultResponse<T> implements Serializable {
    private String status;

    private String code;

    private String message;

    private T data;

    public DefaultResponse() {
        super();
    }

    public DefaultResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
