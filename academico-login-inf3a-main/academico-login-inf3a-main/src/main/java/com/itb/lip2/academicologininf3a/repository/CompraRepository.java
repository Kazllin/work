package com.itb.lip2.academicologininf3a.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.lip2.academicologininf3a.model.Cliente;
import com.itb.lip2.academicologininf3a.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByDataCompraBetween(LocalDateTime start, LocalDateTime end);
    List<Compra> findByCliente(Cliente cliente);
}