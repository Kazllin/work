package com.itb.lip2.academicologininf3a.service;

import com.itb.lip2.academicologininf3a.model.Cliente;

public interface ClienteService {

    Cliente update(Long id, Cliente cliente) throws Exception;
}