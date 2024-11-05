package com.itb.lip2.academicologininf3a.service;

import java.util.List;
import java.util.Optional;

//CarrinhoService.java

import com.itb.lip2.academicologininf3a.model.Carrinho;
import com.itb.lip2.academicologininf3a.model.Cliente;
import com.itb.lip2.academicologininf3a.model.Compra;
import com.itb.lip2.academicologininf3a.model.ProdutoCarrinho;
import com.itb.lip2.academicologininf3a.model.Usuario;

public interface CarrinhoService {
    void adicionarProduto(Carrinho carrinho, ProdutoCarrinho produtoCarrinho);
    double calcularValorTotal(Carrinho carrinho);
    Carrinho criarCarrinho(Usuario usuario);
    Optional<ProdutoCarrinho> findProdutoInCarrinho(Carrinho carrinho, Long produtoId);
    void atualizarCarrinho(Carrinho carrinho);
    List<Carrinho> listarCarrinhos();
	void resetarCarrinhos();
	void finalizarCompra(Compra compra);
}