package com.seuprojeto.produtos.services;

import com.seuprojeto.produtos.dto.ProdutoDTO;
import com.seuprojeto.produtos.models.Produto;
import com.seuprojeto.produtos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto salvar(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setQuantidade(dto.quantidade());
        return repository.save(produto);
    }

    public Produto atualizar(Long id, ProdutoDTO dto) {
        Produto produto = buscar(id);
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setQuantidade(dto.quantidade());
        return repository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscar(id);
        repository.delete(produto);
    }
}
