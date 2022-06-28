package com.example.demo.delivery.auth.impl;

import com.example.demo.configuration.security.JwtTokenUtil;
import com.example.demo.configuration.security.JwtUserDetailsService;
import com.example.demo.delivery.auth.AuthController;
import com.example.demo.persistence.user.repository.UserRepository;
import com.example.demo.shared.exception.GeneralException;
import com.example.demo.shared.exception.UnauthorizedException;
import com.example.demo.user.domain.Auth;
import com.example.demo.user.domain.User;
import com.example.demo.user.usecase.CreateUserUseCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {
//https://github.com/eugenp/tutorials/blob/master/spring-boot-rest/src/main/java/com/baeldung/web/error/RestResponseEntityExceptionHandler.java
    protected final Log logger = LogFactory.getLog(getClass());

    final UserRepository userRepository;
    final AuthenticationManager authenticationManager;
    final JwtUserDetailsService userDetailsService;
    final JwtTokenUtil jwtTokenUtil;

    final CreateUserUseCase createUserUseCase;

    public AuthControllerImpl(UserRepository userRepository, AuthenticationManager authenticationManager,
                                    JwtUserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, CreateUserUseCase createUserUseCase) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<Auth> loginUser(@Valid @RequestBody final User user) throws GeneralException {
        Map<String, Object> responseMap = new HashMap<>();

        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername()
                    , user.getPassword()));
            if (auth.isAuthenticated()) {
                logger.info("Logged In");
                UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                String token = jwtTokenUtil.generateToken(userDetails);
                return ResponseEntity.ok(new Auth(token));
            } else {
                throw new UnauthorizedException("Invalid Credentials");
            }
        } catch (DisabledException e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "User is disabled");
            throw new GeneralException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "User is disabled");
        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("Invalid Credentials");
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");
        }
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody final User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = encoder.encode(user.getPassword());
        user.setPassword(pass);
        createUserUseCase.execute(user);
        for(int i = 0; i < 20; i++) {
            user.setUsername(String.format("%s_%s", user.getUsername(), i));
            createUserUseCase.execute(user);
        }

        return ResponseEntity.ok("OK");
    }
}
