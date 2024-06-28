package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Produto;
import com.marcos.pizzaria_sistema.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto create(Produto prod) {
		return repository.save(prod);
	}

	public Produto findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto update(Long id, Produto prod) {
		Produto prods = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
		prods.setNome(prod.getNome());
		prods.setCodigo(prod.getCodigo());
		prods.setCategoria(prod.getCategoria());
		prods.setPreco(prod.getPreco());
		prods.setIngredientes(prod.getIngredientes());
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
