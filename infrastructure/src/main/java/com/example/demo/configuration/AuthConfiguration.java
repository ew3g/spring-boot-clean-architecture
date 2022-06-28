package com.example.demo.configuration;

import com.example.demo.configuration.security.JwtRequestFilter;
import com.example.demo.configuration.security.JwtTokenUtil;
import com.example.demo.configuration.security.JwtUserDetailsService;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AuthConfiguration {

    private final UserGateway userGateway;
    @Bean
    public JwtUserDetailsService createJwtUserDetailsService() {
        return new JwtUserDetailsService(userGateway);
    }

    @Bean
    public JwtTokenUtil createJwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public JwtRequestFilter createJwtRequestFilter() {
        return new JwtRequestFilter(createJwtUserDetailsService(), createJwtTokenUtil());
    }
}
