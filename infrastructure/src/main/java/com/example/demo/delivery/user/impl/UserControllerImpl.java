package com.example.demo.delivery.user.impl;

import com.example.demo.delivery.user.UserController;
import com.example.demo.shared.exception.GeneralException;
import com.example.demo.user.domain.User;
import com.example.demo.user.usecase.CreateUserUseCase;
import com.example.demo.user.usecase.GetAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<User>> getAllUsers() throws GeneralException {
        return ResponseEntity.ok(getAllUsersUseCase.execute());
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@Valid @RequestBody final User user) throws GeneralException {
        createUserUseCase.execute(user);
        return ResponseEntity.ok().build();
    }
}
