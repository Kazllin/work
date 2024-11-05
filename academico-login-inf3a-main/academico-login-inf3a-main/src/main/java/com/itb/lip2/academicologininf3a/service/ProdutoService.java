package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto save(Produto produto);

    List<Produto> findAll();

    Optional<Produto> findById(Long id);

    Produto update(Long id, Produto produto) throws Exception;

    void delete(Long id);
}