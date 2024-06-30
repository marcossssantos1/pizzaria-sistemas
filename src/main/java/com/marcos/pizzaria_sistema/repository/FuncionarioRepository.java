package com.marcos.pizzaria_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.pizzaria_sistema.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
