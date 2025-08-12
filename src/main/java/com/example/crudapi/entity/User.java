package com.example.crudapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username wajib diisi")
    @Size(min = 3, max = 50, message = "Username minimal 3 huruf")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Email wajib diisi")
    @Email(message = "Format email salah")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password wajib diisi")
    @Size(min = 6, message = "Password minimal 6 karakter")
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
