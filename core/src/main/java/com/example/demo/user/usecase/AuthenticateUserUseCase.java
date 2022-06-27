package com.example.demo.user.usecase;

import com.example.demo.user.domain.Auth;
import com.example.demo.user.domain.User;

public interface AuthenticateUserUseCase {
    public Auth execute(User user);
}
