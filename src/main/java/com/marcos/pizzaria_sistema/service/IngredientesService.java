package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Ingredientes;
import com.marcos.pizzaria_sistema.repository.IngredientesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IngredientesService {

	@Autowired
	private IngredientesRepository repository;

	public Ingredientes create(Ingredientes ingrediente) {
		return repository.save(ingrediente);
	}

	public Ingredientes findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
	}

	public List<Ingredientes> findAll() {
		return repository.findAll();
	}

	public Ingredientes update(Long id, Ingredientes ingrediente) {
		Ingredientes ingredientes = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
		ingredientes.setNome(ingrediente.getNome());
		return repository.save(ingredientes);
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id não localizado na base de dados.");
		}
	}
}
