package com.example.demo.persistence.user.converter;

import com.example.demo.persistence.user.entity.UserEntity;
import com.example.demo.shared.converter.RepositoryConverter;
import com.example.demo.user.domain.User;

public class UserRepositoryConverter implements RepositoryConverter<UserEntity, User> {
    @Override
    public UserEntity toTable(User persistenceObject) {
        return UserEntity.builder()
                .id(persistenceObject.getId())
                .username(persistenceObject.getUsername())
                .password(persistenceObject.getPassword())
                .build();
    }

    @Override
    public User toModel(UserEntity tableObject) {
        return User.builder()
                .id(tableObject.getId())
                .username(tableObject.getUsername())
                .password(tableObject.getPassword())
                .build();
    }
}
