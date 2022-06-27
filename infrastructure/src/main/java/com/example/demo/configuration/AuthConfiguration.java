package com.example.demo.configuration;

import com.example.demo.persistence.user.converter.UserRepositoryConverter;
import com.example.demo.persistence.user.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {
    private UserRepository userRepository;


}
