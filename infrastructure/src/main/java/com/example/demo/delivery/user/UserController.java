package com.example.demo.delivery.user;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.rest.response.DefaultResponse;
import com.example.demo.user.domain.User;

import java.util.List;

public interface UserController {
    DefaultResponse<List<User>> getAllUsers() throws GeneralException;

    DefaultResponse<Void> createUser(User user) throws GeneralException;
}
