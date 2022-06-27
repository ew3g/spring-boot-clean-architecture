package com.example.demo.delivery.auth;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.rest.response.DefaultResponse;
import com.example.demo.user.domain.User;
import org.springframework.http.ResponseEntity;

public interface AuthController {
    ResponseEntity authenticate(User user) throws GeneralException;
}
