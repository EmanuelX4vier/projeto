package com.seuprojeto.produtos.repositories;

import com.seuprojeto.produtos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
