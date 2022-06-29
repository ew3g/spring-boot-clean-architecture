package com.example.demo.user.gateway;

import com.example.demo.user.domain.PageElement;
import com.example.demo.user.domain.User;

import java.util.Optional;

public interface UserGateway {

    PageElement<User> getAllUsers(int page, int size);

    Optional<User> getUser(String username);

    void saveUser(User user);
}
