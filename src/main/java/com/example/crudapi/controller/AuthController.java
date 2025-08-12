//package com.example.crudapi.controller;
//
//import com.example.crudapi.dto.LoginRequestDTO;
//import com.example.crudapi.dto.RegisterRequestDTO;
//import com.example.crudapi.entity.User;
//import com.example.crudapi.services.AuthService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody RegisterRequestDTO request) {
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword()); // password akan di-hash di service
//        User savedUser = authService.register(user);
//        return ResponseEntity.ok(savedUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
//        // Login akan return JWT token atau info user
//        String token = authService.login(request.getUsername(), request.getPassword());
//        return ResponseEntity.ok(token);
//    }
//}
