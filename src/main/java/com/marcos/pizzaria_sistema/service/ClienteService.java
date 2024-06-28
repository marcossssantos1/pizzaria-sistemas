package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Cliente;
import com.marcos.pizzaria_sistema.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente create(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado na base de dados."));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente update(Long id, Cliente cliente) {
		Cliente clientes = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado na base de dados."));
		clientes.setNome(cliente.getNome());
		clientes.setTelefone(cliente.getTelefone());
		return repository.save(clientes);
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id não encontrado na base de dados.");
		}
	}
}
