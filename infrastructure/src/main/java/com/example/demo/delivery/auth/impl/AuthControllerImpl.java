package com.example.demo.delivery.auth.impl;

import com.example.demo.configuration.security.JwtTokenUtil;
import com.example.demo.configuration.security.JwtUserDetailsService;
import com.example.demo.delivery.auth.AuthController;
import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.exception.UnauthorizedException;
import com.example.demo.user.domain.Auth;
import com.example.demo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auth> authenticate(@Valid @RequestBody final User user) throws GeneralException {

        authenticate(user.getUser(), user.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getUser());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new Auth(token));

    }

    private void authenticate(String username, String password) throws GeneralException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException ex) {
            throw new UnauthorizedException(ex.getMessage());
        } catch (Exception ex) {
            throw new GeneralException(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }

    }


    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
