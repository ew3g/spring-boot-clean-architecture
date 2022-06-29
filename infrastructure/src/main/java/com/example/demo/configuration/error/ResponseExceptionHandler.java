package com.example.demo.configuration.error;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.exception.UnauthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseExceptionHandler() {
        super();
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleInternalException(final RuntimeException ex, final WebRequest request) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("timestamp", new Date());
        mapResponse.put("status", 500);
        mapResponse.put("error", "Internal Server Error");
        mapResponse.put("message", ex.getMessage());
        mapResponse.put("path", request.getContextPath());
        return handleExceptionInternal(ex, mapResponse, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
