package com.example.crudapi.services;

import com.example.crudapi.dto.RegisterRequestDTO;
import com.example.crudapi.entity.Auth;

public interface AuthService {
    Auth register(RegisterRequestDTO request);

    String login(String username, String password);
}










