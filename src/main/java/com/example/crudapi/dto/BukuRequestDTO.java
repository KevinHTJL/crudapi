package com.example.crudapi.dto;


import lombok.Data;

@Data
public class BukuRequestDTO {
    private String judul;
    private String penulis;
    private Long mahasiswa_id;

}
