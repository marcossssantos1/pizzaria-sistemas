package com.marcos.pizzaria_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.pizzaria_sistema.model.ProdutoPedido;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {

}
