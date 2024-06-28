package com.marcos.pizzaria_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.pizzaria_sistema.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
