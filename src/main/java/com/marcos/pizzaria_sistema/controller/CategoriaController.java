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

import com.marcos.pizzaria_sistema.dto.CategoriaCrateDto;
import com.marcos.pizzaria_sistema.dto.CategoriaResponseDto;
import com.marcos.pizzaria_sistema.mapper.CategoriaMapper;
import com.marcos.pizzaria_sistema.model.Categoria;
import com.marcos.pizzaria_sistema.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@PostMapping
	public ResponseEntity<CategoriaResponseDto> create(@Valid @RequestBody CategoriaCrateDto dto) {
		Categoria cat = CategoriaMapper.toCategoria(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaResponseDto> findById(@Valid @PathVariable Long id) {
		Categoria cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(CategoriaMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<CategoriaResponseDto>> findAll() {
		List<Categoria> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(CategoriaMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody CategoriaCrateDto dto) {
		Categoria cat = CategoriaMapper.toCategoria(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(CategoriaMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
