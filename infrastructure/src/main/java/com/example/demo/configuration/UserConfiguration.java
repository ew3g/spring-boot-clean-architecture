package com.example.demo.configuration;

import com.example.demo.configuration.security.JwtUserDetailsService;
import com.example.demo.persistence.user.converter.UserRepositoryConverter;
import com.example.demo.persistence.user.impl.UserGatewayImpl;
import com.example.demo.persistence.user.repository.UserRepository;
import com.example.demo.user.usecase.CreateUserUseCaseImpl;
import com.example.demo.user.usecase.GetAllUsersUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    private UserRepository userRepository;

    @Bean
    public UserRepositoryConverter createUserRepositoryConverter() {
        return new UserRepositoryConverter();
    }

    @Bean
    public UserGatewayImpl createUserGatewayImpl() {
        return new UserGatewayImpl(userRepository, createUserRepositoryConverter());
    }

    @Bean
    public GetAllUsersUseCaseImpl createAllUsersUseCase() {
        return new GetAllUsersUseCaseImpl(createUserGatewayImpl());
    }

    @Bean
    public CreateUserUseCaseImpl createUserUseCase() {
        return new CreateUserUseCaseImpl(createUserGatewayImpl());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
