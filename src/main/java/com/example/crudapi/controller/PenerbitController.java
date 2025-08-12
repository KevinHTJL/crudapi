package com.example.crudapi.controller;

import com.example.crudapi.dto.PenerbitRequestDTO;
import com.example.crudapi.entity.Buku;
import com.example.crudapi.entity.Penerbit;
import com.example.crudapi.services.PenerbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/penerbit")
@RequiredArgsConstructor
public class PenerbitController {

    private final PenerbitService penerbitService;

    @PostMapping
    public  ResponseEntity<Penerbit> createPenerbit(@RequestBody PenerbitRequestDTO dto) {
        Penerbit save = penerbitService.savePenerbit(dto);
        return ResponseEntity.ok(save);

    }
//
//    @GetMapping
//    public List<PenerbitRequestDTO> getAll() {
//        return penerbitService.getAllPenerbitDTO();
//    }
//
//    @GetMapping("/{id}")
//    public PenerbitRequestDTO getById(@PathVariable Long id) {
//        return penerbitService.getPenerbitDTOById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        penerbitService.deletePenerbit(id);
    }

