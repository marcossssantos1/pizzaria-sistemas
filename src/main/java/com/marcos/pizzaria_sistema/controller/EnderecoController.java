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

import com.marcos.pizzaria_sistema.dto.EnderecoCreateDto;
import com.marcos.pizzaria_sistema.dto.EnderecoResponseDto;
import com.marcos.pizzaria_sistema.mapper.EnderecoMapper;
import com.marcos.pizzaria_sistema.model.Endereco;
import com.marcos.pizzaria_sistema.service.EnderecoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@PostMapping
	public ResponseEntity<EnderecoResponseDto> create(@Valid @RequestBody EnderecoCreateDto dto) {
		Endereco cat = EnderecoMapper.toEndereco(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(EnderecoMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoResponseDto> findById(@Valid @PathVariable Long id) {
		Endereco cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(EnderecoMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<EnderecoResponseDto>> findAll() {
		List<Endereco> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(EnderecoMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EnderecoResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody EnderecoCreateDto dto) {
		Endereco cat = EnderecoMapper.toEndereco(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(EnderecoMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
