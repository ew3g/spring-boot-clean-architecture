package com.example.demo.user.usecase;

import com.example.demo.user.domain.User;

public interface CreateUserUseCase {

    public void execute(User username);
}
