package com.example.crudapi.services;

import com.example.crudapi.dto.MahasiswaRequestDTO;
import com.example.crudapi.entity.Mahasiswa;

import java.util.List;
import java.util.Optional;

public interface MahasiswaService{
    Mahasiswa createMahasiswa(MahasiswaRequestDTO dto);
    List<Mahasiswa> searchMahasiswaByNama(String nama);
        Optional<Mahasiswa> getMahasiswaById(Long id);
    Mahasiswa updateMahasiswaById(Long id, Mahasiswa updatedMahasiswa);
    void deleteMahasiswaById(Long id);



}
