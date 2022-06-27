package com.example.demo.persistence.user.impl;

import com.example.demo.persistence.user.converter.UserRepositoryConverter;
import com.example.demo.persistence.user.repository.UserRepository;
import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {
    private final UserRepository userRepository;

    private final UserRepositoryConverter userRepositoryConverter;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().map(userEntity -> userRepositoryConverter.toModel(userEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userRepositoryConverter.toTable(user));
    }

    @Override
    public boolean validateUser(User user) {
        return userRepository.findFirstByUserAndPassword(user.getUser(), user.getPassword())
                .isPresent();
    }
}
