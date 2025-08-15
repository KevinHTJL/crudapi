package com.example.crudapi.services.impl;

import com.example.crudapi.dto.RegisterRequestDTO;
import com.example.crudapi.entity.Auth;
import com.example.crudapi.repository.AuthRepository;
import com.example.crudapi.security.JwtUtil;
import com.example.crudapi.services.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(AuthRepository authRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Auth register(RegisterRequestDTO request) {
        Optional<Auth> existingAuth = authRepository.findByUsername(request.getUsername());
        if (existingAuth.isPresent()) {
            throw new RuntimeException("Username sudah digunakan!");
        }

        Auth auth = new Auth();
        auth.setUsername(request.getUsername());
        auth.setPassword(passwordEncoder.encode(request.getPassword()));
        auth.setEmail(request.getEmail());
        auth.setName(request.getName());

        return authRepository.save(auth);
    }


    @Override
    public String login(String username, String password) {
        Auth auth = authRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Username tidak ditemukan!"));

        if (!passwordEncoder.matches(password, auth.getPassword())) {
            throw new RuntimeException("Password salah!");
        }

        return jwtUtil.generateToken(auth.getUsername());
    }
}