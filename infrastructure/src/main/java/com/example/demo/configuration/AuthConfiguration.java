package com.example.demo.configuration;

import com.example.demo.configuration.security.JwtAuthenticationEntryPoint;
import com.example.demo.configuration.security.JwtRequestFilter;
import com.example.demo.configuration.security.JwtTokenUtil;
import com.example.demo.configuration.security.JwtUserDetailsService;
import com.example.demo.persistence.user.converter.UserRepositoryConverter;
import com.example.demo.persistence.user.impl.UserGatewayImpl;
import com.example.demo.persistence.user.repository.UserRepository;
import com.example.demo.user.gateway.UserGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfiguration {
    private UserRepository userRepository;

    private UserRepositoryConverter userRepositoryConverter;

    private UserGateway userGateway;

//    @Bean
//    public UserRepositoryConverter createUserRepositoryConverter() {
//        return new UserRepositoryConverter();
//    }
//    @Bean
//    public UserGatewayImpl createUserGatewayImpl() {
//        return new UserGatewayImpl(userRepository, userRepositoryConverter);
//    }

    @Bean
    JwtTokenUtil createJwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    JwtUserDetailsService createJwtUserDetailsService() {
        return new JwtUserDetailsService(userGateway);
    }

    @Bean
    JwtAuthenticationEntryPoint createJwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    @Bean
    JwtRequestFilter createJwtRequestFilter() {
        return new JwtRequestFilter(createJwtUserDetailsService(), createJwtTokenUtil());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
