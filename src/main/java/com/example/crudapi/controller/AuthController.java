package com.example.crudapi.controller;

import com.example.crudapi.dto.LoginRequestDTO;
import com.example.crudapi.dto.RegisterRequestDTO;
import com.example.crudapi.entity.Auth;
import com.example.crudapi.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Auth> register(@Valid @RequestBody RegisterRequestDTO request) {
        Auth savedAuth = authService.register(request);
        return ResponseEntity.ok(savedAuth);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            String token = authService. login(request.getUsername(), request.getPassword());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed: " + e.getMessage());
        }
    }
}