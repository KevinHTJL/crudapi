package com.example.crudapi.dto;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class MahasiswaRequestDTO {
    private String nim;
    private String nama;
    private String jurusan;

}
