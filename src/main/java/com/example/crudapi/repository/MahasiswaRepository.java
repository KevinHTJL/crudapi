package com.example.crudapi.repository;

import com.example.crudapi.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    boolean existsByNim(String nim);
    List<Mahasiswa> findByNamaContainingIgnoreCase(String nama);
}
