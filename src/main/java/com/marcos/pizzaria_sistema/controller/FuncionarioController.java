package com.marcos.pizzaria_sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.pizzaria_sistema.dto.FuncionarioCreateDto;
import com.marcos.pizzaria_sistema.dto.FuncionarioResponseDto;
import com.marcos.pizzaria_sistema.mapper.FuncionarioMapper;
import com.marcos.pizzaria_sistema.model.Funcionario;
import com.marcos.pizzaria_sistema.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@PostMapping
	public ResponseEntity<FuncionarioResponseDto> create(@Valid @RequestBody FuncionarioCreateDto dto) {
		Funcionario cat = FuncionarioMapper.toFuncionario(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioResponseDto> findById(@Valid @PathVariable Long id) {
		Funcionario cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(FuncionarioMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<FuncionarioResponseDto>> findAll() {
		List<Funcionario> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(FuncionarioMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody FuncionarioCreateDto dto) {
		Funcionario cat = FuncionarioMapper.toFuncionario(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(FuncionarioMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
