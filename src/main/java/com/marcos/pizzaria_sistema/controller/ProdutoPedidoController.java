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

import com.marcos.pizzaria_sistema.dto.ProdutoPedidoCreateDto;
import com.marcos.pizzaria_sistema.dto.ProdutoPedidoResponseDto;
import com.marcos.pizzaria_sistema.mapper.ProdutoPedidoMapper;
import com.marcos.pizzaria_sistema.model.ProdutoPedido;
import com.marcos.pizzaria_sistema.service.ProdutoPedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/produtos_pedidos")
public class ProdutoPedidoController {

	@Autowired
	private ProdutoPedidoService service;

	@PostMapping
	public ResponseEntity<ProdutoPedidoResponseDto> create(@Valid @RequestBody ProdutoPedidoCreateDto dto) {
		ProdutoPedido cat = ProdutoPedidoMapper.toProdutoPedido(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoPedidoMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoPedidoResponseDto> findById(@Valid @PathVariable Long id) {
		ProdutoPedido cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoPedidoMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<ProdutoPedidoResponseDto>> findAll() {
		List<ProdutoPedido> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoPedidoMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoPedidoResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody ProdutoPedidoCreateDto dto) {
		ProdutoPedido cat = ProdutoPedidoMapper.toProdutoPedido(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoPedidoMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
