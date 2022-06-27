package com.example.demo.delivery.auth.impl;

import com.example.demo.delivery.auth.AuthController;
import com.example.demo.shared.constants.GeneralConstants;
import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.rest.response.DefaultResponse;
import com.example.demo.user.domain.User;
import com.example.demo.user.usecase.AuthenticateUserUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthenticateUserUseCaseImpl authenticateUserUseCase;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DefaultResponse authenticate(@Valid @RequestBody final User user) throws GeneralException {
        return new DefaultResponse(GeneralConstants.STATUS_OK, String.valueOf(HttpStatus.OK), GeneralConstants.MESSAGE_OK, authenticateUserUseCase.execute(user));
    }
}
