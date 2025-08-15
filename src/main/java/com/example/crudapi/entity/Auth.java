package com.example.crudapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;





}
