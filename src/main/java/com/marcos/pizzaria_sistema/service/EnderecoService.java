package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Endereco;
import com.marcos.pizzaria_sistema.repository.EnderecoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public Endereco create(Endereco prod) {
		return repository.save(prod);
	}

	public Endereco findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
	}

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco update(Long id, Endereco prod) {
		Endereco prods = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
		prods.setRua(prod.getRua());
		prods.setNumero(prod.getNumero());
		prods.setReferencia(prod.getReferencia());
		return repository.save(prods);
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id não localizado na base de dados.");
		}
	}

}
