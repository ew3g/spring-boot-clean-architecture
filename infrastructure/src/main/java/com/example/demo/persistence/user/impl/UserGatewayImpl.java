package com.example.demo.persistence.user.impl;

import com.example.demo.persistence.user.converter.UserRepositoryConverter;
import com.example.demo.persistence.user.entity.UserEntity;
import com.example.demo.persistence.user.repository.UserRepository;
import com.example.demo.user.domain.PageElement;
import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    private final UserRepositoryConverter userRepositoryConverter;

    @Override
    public PageElement<User> getAllUsers(int page, int size) {
        Page<UserEntity> userEntityPage = userRepository.findAll(PageRequest.of(page, size));
        return PageElement.<User>builder()
                .page(userEntityPage.getNumber())
                .size(userEntityPage.getSize())
                .data(userEntityPage.get().map(userEntity ->
                        userRepositoryConverter.toModel(userEntity)).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Optional<User> getUser(String user) {
        Optional<UserEntity> optUser = userRepository.findFirstByUsername(user);
        return optUser.isPresent() ? Optional.of(userRepositoryConverter.toModel(optUser.get())) : Optional.empty();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userRepositoryConverter.toTable(user));
    }
}
