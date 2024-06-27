package com.marcos.pizzaria_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.pizzaria_sistema.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
