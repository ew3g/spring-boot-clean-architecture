package com.example.demo.configuration.security;

import com.example.demo.user.domain.User;
import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserGateway userGateway;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOpt = userGateway.getUser(username);
        if(!userOpt.isPresent()) {
            throw new UsernameNotFoundException(String.format("Username not found: ", username));
        }

        User user = userOpt.get();
        return new org.springframework.security.core.userdetails.User(user.getUser(),
                user.getPassword(), new ArrayList<>());
    }
}
