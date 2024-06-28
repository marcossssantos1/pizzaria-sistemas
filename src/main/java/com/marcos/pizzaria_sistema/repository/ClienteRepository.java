package com.marcos.pizzaria_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.pizzaria_sistema.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
