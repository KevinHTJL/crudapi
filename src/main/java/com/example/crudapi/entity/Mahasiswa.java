package com.example.crudapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mahasiswa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String nim;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(length = 100)
    private String jurusan;
}
