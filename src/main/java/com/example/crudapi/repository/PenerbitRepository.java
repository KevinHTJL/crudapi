package com.example.crudapi.repository;

import com.example.crudapi.entity.Penerbit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenerbitRepository extends JpaRepository<Penerbit, Long> {
}
