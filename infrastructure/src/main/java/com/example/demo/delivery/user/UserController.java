package com.example.demo.delivery.user;

import com.example.demo.shared.exception.GeneralException;
import com.example.demo.user.domain.PageElement;
import com.example.demo.user.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<PageElement<User>> getAllUsers(int page, int size) throws GeneralException;

    ResponseEntity<Void> createUser(User user) throws GeneralException;

    //https://blog.iamprafful.com/spring-boot-rest-api-authentication-best-practices-using-jwt-2022
}
