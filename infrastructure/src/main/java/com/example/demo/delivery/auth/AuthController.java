package com.example.demo.delivery.auth;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.rest.response.DefaultResponse;
import com.example.demo.user.domain.User;

public interface AuthController {
    DefaultResponse authenticate(User user) throws GeneralException;
}
