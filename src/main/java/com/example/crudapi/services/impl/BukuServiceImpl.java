package com.example.crudapi.services.impl;

import com.example.crudapi.GlobalExceptionHandler.BadRequestException;
import com.example.crudapi.dto.BukuRequestDTO;
import com.example.crudapi.entity.Buku;
import com.example.crudapi.entity.Mahasiswa;
import com.example.crudapi.repository.BukuRepository;
import com.example.crudapi.repository.MahasiswaRepository;
import com.example.crudapi.services.BukuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BukuServiceImpl implements BukuService {

    private final BukuRepository bukuRepository;
    @Autowired
    MahasiswaRepository mahasiswaRepository;


    @Override
    public List<Buku> getAllBuku() {
        List<Buku> list = bukuRepository.findAll();
        if (list.isEmpty()) {
            throw new RuntimeException("Data buku tidak ditemukan");
        }
        return list;
    }


    @Override
    public Buku getBukuById(Long id) {
        Buku buku = bukuRepository.findByIdWithMahasiswa(id);
        if (buku == null) {
            throw new BadRequestException("Buku dengan id " + id + " tidak ditemukan");
        }
        return buku;
    }


    @Override
    public Buku saveBuku(BukuRequestDTO dto) {
        Mahasiswa mahasiswa = mahasiswaRepository.findById(dto.getMahasiswa_id())
                .orElseThrow(() -> new RuntimeException("Mahasiswa tidak ditemukan"));

        Buku buku = new Buku();
        buku.setJudul(dto.getJudul());
        buku.setPenulis(dto.getPenulis());
        buku.setMahasiswa(mahasiswa);

        return bukuRepository.save(buku);
    }


    @Override
    public void deleteBuku(Long id) {
        bukuRepository.deleteById(id);
    }

    @Override
    public List<Buku> getBukuByMahasiswaId(Long mahasiswaId) {
        return bukuRepository.findByMahasiswaId(mahasiswaId);
    }

    @Override
    public Buku updateBukuById(Long id, Buku buku) {
        Buku existing = bukuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));

        existing.setJudul(buku.getJudul());
        existing.setPenulis(buku.getPenulis());

        if (buku.getMahasiswa() != null && buku.getMahasiswa().getId() != null) {
            Mahasiswa mhs = mahasiswaRepository.findById(buku.getMahasiswa().getId())
                    .orElseThrow(() -> new RuntimeException("Mahasiswa tidak ditemukan"));
            existing.setMahasiswa(mhs);
        }

        return bukuRepository.save(existing);
    }
}