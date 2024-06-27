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

import com.marcos.pizzaria_sistema.dto.IngredientesCreateDto;
import com.marcos.pizzaria_sistema.dto.IngredientesResponseDto;
import com.marcos.pizzaria_sistema.mapper.IngredientesMapper;
import com.marcos.pizzaria_sistema.model.Ingredientes;
import com.marcos.pizzaria_sistema.service.IngredientesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/ingredientes")
public class IngredientesController {

	@Autowired
	private IngredientesService service;

	@PostMapping
	public ResponseEntity<IngredientesResponseDto> create(@Valid @RequestBody IngredientesCreateDto dto) {
		Ingredientes cat = IngredientesMapper.toIngredientes(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(IngredientesMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<IngredientesResponseDto> findById(@Valid @PathVariable Long id) {
		Ingredientes cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(IngredientesMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<IngredientesResponseDto>> findAll() {
		List<Ingredientes> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(IngredientesMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<IngredientesResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody IngredientesCreateDto dto) {
		Ingredientes cat = IngredientesMapper.toIngredientes(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(IngredientesMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
