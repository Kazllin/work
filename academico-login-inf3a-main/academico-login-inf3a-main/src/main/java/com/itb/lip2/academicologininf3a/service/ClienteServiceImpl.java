package com.itb.lip2.academicologininf3a.service;


import com.itb.lip2.academicologininf3a.model.Cliente;
import com.itb.lip2.academicologininf3a.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // @Autowired
   // private  AlunoRepository alunoRepository;
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }
    @Override
    @Transactional
    public Cliente update(Long id, Cliente cliente) throws Exception {
        return clienteRepository.findById(id).map(cl ->{
            cl.setNome(cliente.getNome());
            cl.setEmail(cliente.getEmail());
            cl.setDataNascimento(cliente.getDataNascimento());
            cl.setRm(cliente.getRm());
            cl.setCodStatusUsuario(cliente.isCodStatusUsuario());
            return clienteRepository.save(cl);
        }).orElseThrow(()->new Exception("cliente não encontrado!"));
    }
}