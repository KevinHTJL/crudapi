package com.example.crudapi.controller;

import com.example.crudapi.dto.MahasiswaRequestDTO;
import com.example.crudapi.entity.Mahasiswa;
import com.example.crudapi.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

@Autowired
MahasiswaService mahasiswaService;

    @PostMapping
    public ResponseEntity<Mahasiswa> createMahasiswa(@RequestBody MahasiswaRequestDTO dto) {
        Mahasiswa created = mahasiswaService.createMahasiswa(dto);
        return ResponseEntity.ok(created);
    }
    @GetMapping("/search")
    public ResponseEntity<  List<Mahasiswa>> searchByNama(@RequestParam String nama) {
        List<Mahasiswa> result = mahasiswaService.searchMahasiswaByNama(nama);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable Long id, @RequestBody Mahasiswa mahasiswa) {
        try {
            Mahasiswa updated = mahasiswaService.updateMahasiswaById(id, mahasiswa);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mahasiswa> getMahasiswaById(@PathVariable Long id) {
        return mahasiswaService.getMahasiswaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMahasiswa(@PathVariable Long id) {
        try {
            mahasiswaService.deleteMahasiswaById(id);
            return ResponseEntity.ok("Mahasiswa berhasil dihapus");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
