//package com.example.crudapi.service.impl;
//
//import com.example.crudapi.entity.User;
//import com.example.crudapi.repository.UserRepository;
//import com.example.crudapi.services.AuthService;
//import com.example.crudapi.util.JwtUtil;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtUtil jwtUtil;
//
//    public AuthServiceImpl(UserRepository userRepository,
//                           PasswordEncoder passwordEncoder,
//                           JwtUtil jwtUtil) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    public User register(User user) {
//        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
//        if (existingUser.isPresent()) {
//            throw new RuntimeException("Username sudah digunakan!");
//        }
//
//        // Hash password sebelum simpan
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public String login(String username, String password) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("Username tidak ditemukan!"));
//
//        // Cek password dengan hash
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Password salah!");
//        }
//
//        // Jika sukses, generate JWT token
//        return JwtUtil.generateToken(user.getUsername());
//    }
//}
