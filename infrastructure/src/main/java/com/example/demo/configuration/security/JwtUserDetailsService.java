package com.example.demo.configuration.security;

import com.example.demo.user.gateway.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserGateway userGateway;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
        Optional<com.example.demo.user.domain.User> optUser = userGateway.getUser(username);
        if (!optUser.isPresent()) {
           throw new UsernameNotFoundException(String.format("Username %s not found", username));
        }
        com.example.demo.user.domain.User user = optUser.get();
        return new User(user.getUsername(), user.getPassword(), authorityList);
    }
}
