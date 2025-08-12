package com.example.crudapi.services;

import com.example.crudapi.dto.PenerbitRequestDTO;
import com.example.crudapi.entity.Mahasiswa;
import com.example.crudapi.entity.Penerbit;

import java.util.List;
import java.util.Optional;

public interface PenerbitService {
    Penerbit savePenerbit(PenerbitRequestDTO dto);
    List<Penerbit> getAllPenerbitDTO();
    Optional<Penerbit> getPenerbitById(Long id);
    void deletePenerbit(Long id);
}
