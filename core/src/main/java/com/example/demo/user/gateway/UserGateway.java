package com.example.demo.user.gateway;

import com.example.demo.user.domain.User;

import java.util.List;

public interface UserGateway {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public boolean validateUser(User user);
}
