package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Categoria;
import com.marcos.pizzaria_sistema.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria create(Categoria cat) {
		return repository.save(cat);
	}

	public Categoria findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado na base de dados."));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria update(Long id, Categoria cat) {
		Categoria cats = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado na base de dados."));
		cats.setNome(cat.getNome());
		return repository.save(cats);
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id não encontrado na base de dados.");
		}
	}
}
