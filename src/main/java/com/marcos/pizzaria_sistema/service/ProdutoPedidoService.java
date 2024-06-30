package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.ProdutoPedido;
import com.marcos.pizzaria_sistema.repository.ProdutoPedidoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoPedidoService {

	@Autowired
	private ProdutoPedidoRepository repository;

	public ProdutoPedido create(ProdutoPedido prodPed) {
		return repository.save(prodPed);
	}

	public ProdutoPedido findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
	}

	public List<ProdutoPedido> findAll() {
		return repository.findAll();
	}

	public ProdutoPedido update(Long id, ProdutoPedido prod) {
		ProdutoPedido prods = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
		prods.setObservacao(prod.getObservacao());
		prods.setProduto(prod.getProduto());
		prods.setQuantidade(prod.getQuantidade());
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
