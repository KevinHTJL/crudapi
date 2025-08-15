package com.example.crudapi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    @NotBlank(message = "Username wajib diisi")
    private String username;

    @NotBlank(message = "Name wajib diisi")
    private String name;

    @NotBlank(message = "Email wajib diisi")
    @Email(message = "Format email salah")
    private String email;

    @NotBlank(message = "Password wajib diisi")
    @Size(min = 6, message = "Password minimal 6 karakter")
    private String password;

}

