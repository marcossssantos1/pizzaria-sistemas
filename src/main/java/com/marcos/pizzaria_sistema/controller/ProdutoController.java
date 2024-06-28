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

import com.marcos.pizzaria_sistema.dto.ProdutoCreateDto;
import com.marcos.pizzaria_sistema.dto.ProdutoResponseDto;
import com.marcos.pizzaria_sistema.mapper.ProdutoMapper;
import com.marcos.pizzaria_sistema.model.Produto;
import com.marcos.pizzaria_sistema.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@PostMapping
	public ResponseEntity<ProdutoResponseDto> create(@Valid @RequestBody ProdutoCreateDto dto) {
		Produto cat = ProdutoMapper.toProduto(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDto> findById(@Valid @PathVariable Long id) {
		Produto cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDto>> findAll() {
		List<Produto> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody ProdutoCreateDto dto) {
		Produto cat = ProdutoMapper.toProduto(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
