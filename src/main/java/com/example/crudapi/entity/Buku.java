package com.example.crudapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buku")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String judul;

    @Column(nullable = false, length = 100)
    private String penulis;

    @ManyToOne
    @JoinColumn(name = "mahasiswa_id")
    private Mahasiswa mahasiswa;



}
