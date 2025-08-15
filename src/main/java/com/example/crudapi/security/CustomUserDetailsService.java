package com.example.crudapi.security;

import com.example.crudapi.entity.Auth;
import com.example.crudapi.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Autowired
    public CustomUserDetailsService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User tidak ditemukan: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(auth.getUsername())
                .password(auth.getPassword())
                .authorities("USER")
                .build();
    }
}