package com.marcos.pizzaria_sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.pizzaria_sistema.model.Funcionario;
import com.marcos.pizzaria_sistema.repository.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public Funcionario create(Funcionario func) {
		return repository.save(func);
	}

	public Funcionario findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados"));
	}

	public List<Funcionario> findAll() {
		return repository.findAll();
	}

	public Funcionario update(Long id, Funcionario func) {
		Funcionario funcs = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não localizado na base de dados"));
		funcs.setNome(func.getNome());
		funcs.setRegistro(func.getRegistro());
		funcs.setSenha(func.getSenha());
		return repository.save(funcs);
	}

	public void deleteById(Long id) {
		if (id != null) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id não localizado na base de dados.");
		}
	}

}
