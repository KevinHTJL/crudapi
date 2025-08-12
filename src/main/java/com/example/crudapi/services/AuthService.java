package com.example.crudapi.services;

import com.example.crudapi.entity.User;

public interface AuthService {
    User register(User user);
    String login(String username, String password);
}










