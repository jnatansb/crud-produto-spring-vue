package com.projeto.crud_produtos.repository;

import com.projeto.crud_produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {




}
