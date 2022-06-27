package com.example.demo.user.gateway;

import com.example.demo.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {

    List<User> getAllUsers();

    public Optional<User> getUser(String user);

    void saveUser(User user);
}
