package com.example.crudapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "penerbit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Penerbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String nama;

    @Column(nullable = false, length = 100)
    private String alamat;

    @ManyToOne
    @JoinColumn(name = "buku_id")
    private Buku buku;

}
