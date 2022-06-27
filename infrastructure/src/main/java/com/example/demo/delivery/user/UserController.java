package com.example.demo.delivery.user;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.rest.response.DefaultResponse;
import com.example.demo.user.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<List<User>> getAllUsers() throws GeneralException;

    ResponseEntity<Void> createUser(User user) throws GeneralException;
}
