package com.example.demo.delivery.user.impl;

import com.example.demo.delivery.user.UserController;
import com.example.demo.shared.constants.GeneralConstants;
import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.rest.response.DefaultResponse;
import com.example.demo.user.domain.User;
import com.example.demo.user.usecase.CreateUserUseCase;
import com.example.demo.user.usecase.GetAllUsersUseCase;
import com.example.demo.user.usecase.GetAllUsersUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo/v1/user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final GetAllUsersUseCase getAllUsersUseCase;

    private final CreateUserUseCase createUserUseCase;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DefaultResponse<List<User>> getAllUsers() throws GeneralException {
        return new DefaultResponse<>(GeneralConstants.STATUS_OK, String.valueOf(HttpStatus.OK),
                GeneralConstants.MESSAGE_OK, getAllUsersUseCase.execute());
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DefaultResponse<Void> createUser(@Valid @RequestBody final User user) throws GeneralException {
        createUserUseCase.execute(user);
        return new DefaultResponse<>(GeneralConstants.STATUS_OK, String.valueOf(HttpStatus.CREATED),
                GeneralConstants.MESSAGE_OK);
    }
}
