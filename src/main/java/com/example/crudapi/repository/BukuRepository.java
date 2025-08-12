package com.example.crudapi.repository;

import com.example.crudapi.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    List<Buku> findByMahasiswaId(Long mahasiswaId);
    @Query("SELECT b FROM Buku b LEFT JOIN FETCH b.mahasiswa")
    List<Buku> findAllWithMahasiswa();

    @Query("SELECT b FROM Buku b LEFT JOIN FETCH b.mahasiswa WHERE b.id = :id")
    Buku findByIdWithMahasiswa(@Param("id") Long id);


    @Query("UPDATE Buku b SET b.judul = :judul, b.penulis = :penulis, b.mahasiswa.id = :mahasiswaId WHERE b.id = :id")
    int updateBuku(Long id, String judul, String penulis, Long mahasiswaId);
}
