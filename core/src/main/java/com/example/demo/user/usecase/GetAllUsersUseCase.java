package com.example.demo.user.usecase;

import com.example.demo.user.domain.User;

import java.util.List;

public interface GetAllUsersUseCase {
    public List<User> execute();
}
