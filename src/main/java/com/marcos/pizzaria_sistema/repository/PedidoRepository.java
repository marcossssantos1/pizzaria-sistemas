package com.marcos.pizzaria_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.pizzaria_sistema.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
