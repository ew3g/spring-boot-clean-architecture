package com.example.demo.delivery.auth;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.user.domain.Auth;
import com.example.demo.user.domain.User;
import org.springframework.http.ResponseEntity;

public interface AuthController {
    ResponseEntity<Auth> loginUser(User user) throws GeneralException;

    ResponseEntity<String> createUser(User user);
}
