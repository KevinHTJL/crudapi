package com.example.crudapi.services.impl;

import com.example.crudapi.dto.BukuRequestDTO;
import com.example.crudapi.dto.PenerbitRequestDTO;
import com.example.crudapi.entity.Buku;
import com.example.crudapi.entity.Mahasiswa;
import com.example.crudapi.entity.Penerbit;
import com.example.crudapi.repository.BukuRepository;
import com.example.crudapi.repository.PenerbitRepository;
import com.example.crudapi.services.PenerbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PenerbitServiceImpl implements PenerbitService {

    private final PenerbitRepository penerbitRepository;
    private final BukuRepository bukuRepository;



    @Override
    public List<Penerbit> getAllPenerbitDTO() {
        return penerbitRepository.findAll();
    }

    @Override
    public Optional<Penerbit> getPenerbitById(Long id) {
        return penerbitRepository.findById(id);
    }

    @Override
    public void deletePenerbit(Long id) {
        penerbitRepository.deleteById(id);
    }

    @Override
    public Penerbit savePenerbit(PenerbitRequestDTO dto) {
       Buku buku = bukuRepository.findById(dto.getBuku_id())
                .orElseThrow(() -> new RuntimeException("Mahasiswa tidak ditemukan"));

        Penerbit penerbit = new Penerbit();
        penerbit.setNama(dto.getNama());
        penerbit.setAlamat(dto.getAlamat());
        penerbit.setBuku(buku);

        return penerbitRepository.save(penerbit);
    }
}
