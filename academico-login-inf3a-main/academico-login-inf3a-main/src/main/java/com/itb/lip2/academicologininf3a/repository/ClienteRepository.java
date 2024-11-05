package com.itb.lip2.academicologininf3a.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itb.lip2.academicologininf3a.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long >{
}