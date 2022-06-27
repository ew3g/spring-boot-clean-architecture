package com.example.demo.user.usecase;

import com.example.demo.user.domain.Auth;
import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticateUserUseCaseImpl implements AuthenticateUserUseCase{
    private final UserGateway userGateway;

    @Override
    public Auth execute(User user) {
        boolean a = userGateway.validateUser(user);
        if(a) {
            return new Auth("valido");
        } else {
            return new Auth("n valido");
        }
    }
}
