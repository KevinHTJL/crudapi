package com.example.crudapi.services;

import com.example.crudapi.dto.BukuRequestDTO;
import com.example.crudapi.entity.Buku;
import com.example.crudapi.entity.Mahasiswa;

import java.util.List;

public interface BukuService {
    List<Buku> getAllBuku();
    Buku getBukuById(Long id);
    Buku saveBuku(BukuRequestDTO dto);
    Buku updateBukuById(Long id, Buku updatedBuku);
    void deleteBuku(Long id);
    List<Buku> getBukuByMahasiswaId(Long mahasiswaId);
}
