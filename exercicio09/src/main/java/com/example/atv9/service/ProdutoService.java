package com.example.atv9.service;

import com.example.atv9.model.Produto;
import com.example.atv9.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);

    }

    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.findById(id).orElse(null);
        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());

            return produtoRepository.save(produtoExistente);
        }
        return null;
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> buscarProdutoPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

}