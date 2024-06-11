package com.example.atv9.controller;

import com.example.atv9.dto.ProdutoRequestDTO;
import com.example.atv9.dto.ProdutoResponseDTO;
import com.example.atv9.model.Produto;
import com.example.atv9.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoResponseDTO criarProduto(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.getNome());
        produto.setPreco(produtoRequestDTO.getPreco());
        Produto produtoCriado = produtoService.criarProduto(produto);

        return new ProdutoResponseDTO(produtoCriado.getId(), produtoCriado.getNome(), produtoCriado.getPreco());
    }

    @GetMapping
    public List<ProdutoResponseDTO> obterTodosProdutos() {
        return produtoService.obterTodosProdutos().stream()
                .map(produto -> new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO obterProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.obterProdutoPorId(id);

        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco());
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.getNome());
        produto.setPreco(produtoRequestDTO.getPreco());

        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);

        return new ProdutoResponseDTO(produtoAtualizado.getId(), produtoAtualizado.getNome(), produtoAtualizado.getPreco());

    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

    @GetMapping("/buscar")
    public List<ProdutoResponseDTO> buscarProdutoPorNome(@RequestParam String nome) {
        return produtoService.buscarProdutoPorNome(nome).stream()
                .map(produto -> new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco()))
                .collect(Collectors.toList());
    }

}









