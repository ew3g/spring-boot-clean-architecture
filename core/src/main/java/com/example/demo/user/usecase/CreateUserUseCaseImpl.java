package com.example.demo.user.usecase;

import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase{
    private final UserGateway userGateway;

    @Override
    public void execute(User user) {
        userGateway.saveUser(user);
    }
}
