package com.example.crudapi.services.impl;

import com.example.crudapi.dto.MahasiswaRequestDTO;
import com.example.crudapi.entity.Mahasiswa;
import com.example.crudapi.repository.MahasiswaRepository;
import com.example.crudapi.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;

    @Autowired
    public MahasiswaServiceImpl(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    @Override
    public Mahasiswa createMahasiswa(MahasiswaRequestDTO dto) {
        if (mahasiswaRepository.existsByNim(dto.getNim())) {
            throw new RuntimeException("NIM sudah terdaftar");
        }

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(dto.getNim());
        mahasiswa.setNama(dto.getNama());
        mahasiswa.setJurusan(dto.getJurusan());

        return mahasiswaRepository.save(mahasiswa);

    }
    @Override
    public List<Mahasiswa> searchMahasiswaByNama(String nama) {
        return mahasiswaRepository.findByNamaContainingIgnoreCase(nama);
    }
    @Override
    public Optional<Mahasiswa> getMahasiswaById(Long id) {
        return mahasiswaRepository.findById(id);
    }
    @Override
    public Mahasiswa updateMahasiswaById(Long id, Mahasiswa updatedMahasiswa) {
        Mahasiswa existing = mahasiswaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mahasiswa tidak ditemukan"));

        existing.setNim(updatedMahasiswa.getNim());
        existing.setNama(updatedMahasiswa.getNama());
        existing.setJurusan(updatedMahasiswa.getJurusan());

        return mahasiswaRepository.save(existing);
    }
    @Override
    public void deleteMahasiswaById(Long id) {
        if (!mahasiswaRepository.existsById(id)) {
            throw new RuntimeException("Mahasiswa dengan ID " + id + " tidak ditemukan");
        }
        mahasiswaRepository.deleteById(id);
    }   

}
