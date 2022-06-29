package com.example.demo.user.usecase;

import com.example.demo.user.domain.PageElement;
import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {
    private final UserGateway userGateway;

    @Override
    public PageElement<User> execute(int page, int size) {
        return userGateway.getAllUsers(page, size);
    }
}
