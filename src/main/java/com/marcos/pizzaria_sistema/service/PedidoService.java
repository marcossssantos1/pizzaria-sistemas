package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Pedido;
import com.marcos.pizzaria_sistema.repository.PedidoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public Pedido create(Pedido ped) {
		return repository.save(ped);
	}

	public Pedido findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
	}

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido update(Long id, Pedido ped) {
		Pedido peds = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados."));
		peds.setValor(ped.getValor());
		peds.setStatus(ped.getStatus());
		peds.setForma_pagamento(ped.getForma_pagamento());
		peds.setDataHora(ped.getDataHora());
		peds.setEndereco(ped.getEndereco());
		peds.setProdutos(ped.getProdutos());
		return repository.save(peds);
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id não localizado na base de dados.");
		}
	}

}
