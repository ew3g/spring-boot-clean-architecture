package com.example.demo.user.usecase;

import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {
    private final UserGateway userGateway;

    @Override
    public List<User> execute() {
        return userGateway.getAllUsers();
    }
}
