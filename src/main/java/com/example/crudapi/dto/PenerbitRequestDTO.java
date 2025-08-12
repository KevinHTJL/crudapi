package com.example.crudapi.dto;

import lombok.Data;

@Data
public class PenerbitRequestDTO {
    private String nama;
    private String alamat;
    private Long buku_id;

}