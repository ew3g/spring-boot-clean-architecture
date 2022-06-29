package com.example.demo.user.usecase;

import com.example.demo.user.domain.PageElement;
import com.example.demo.user.domain.User;

public interface GetAllUsersUseCase {

    public PageElement<User> execute(int page, int size);
}
