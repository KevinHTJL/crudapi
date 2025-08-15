//package com.example.crudapi.controller;
//
//import com.example.crudapi.entity.Auth;
//import com.example.crudapi.repository.AuthRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private AuthRepository authRepository;
//
//    @GetMapping
//    public List<Auth> getAllUsers() {
//        return authRepository.findAll();
//    }
//
//    @PostMapping
//    public Auth createUser(@RequestBody Auth auth) {
//        return authRepository.save(auth);
//    }
//
//    @GetMapping("/{id}")
//    public Auth getUserById(@PathVariable Long id) {
//        return authRepository.findById(id).orElse(null);
//    }
//
//    @PutMapping("/{id}")
//    public Auth updateAuth(@PathVariable Long id, @RequestBody Auth updatedAuth) {
//        return authRepository.findById(id).map(user -> {
//            user.setUsername(updatedAuth.getUsername());
//            user.setEmail(updatedAuth.getEmail());
//            user.setPassword(updatedAuth.getPassword());
//            return authRepository.save(user);
//        }).orElse(null);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        authRepository.deleteById(id);
//    }
//}
