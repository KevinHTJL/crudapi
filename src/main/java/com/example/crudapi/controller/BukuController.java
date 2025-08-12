package com.example.crudapi.controller;

import com.example.crudapi.dto.BukuRequestDTO;
import com.example.crudapi.entity.Buku;
import com.example.crudapi.services.BukuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
@RequiredArgsConstructor
public class BukuController {

    private final BukuService bukuService;

    @GetMapping
    public List<Buku> getAllBuku() {
        return bukuService.getAllBuku();
    }



    @GetMapping("/{id}")
    public Buku getBukuById(@PathVariable Long id) {
        return bukuService.getBukuById(id);
    }

    @PostMapping
    public Buku createBuku(@RequestBody BukuRequestDTO dto) {
        return bukuService.saveBuku(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBuku(@PathVariable Long id) {
        bukuService.deleteBuku(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buku> updateBuku(@PathVariable Long id, @RequestBody Buku buku) {
        try {
            Buku updated = bukuService.updateBukuById(id, buku);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/mahasiswa/{mahasiswaId}")
    public List<Buku> getBukuByMahasiswa(@PathVariable Long mahasiswaId) {
        return bukuService.getBukuByMahasiswaId(mahasiswaId);
    }
}
