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

import com.marcos.pizzaria_sistema.dto.PedidoCreateDto;
import com.marcos.pizzaria_sistema.dto.PedidoResponseDto;
import com.marcos.pizzaria_sistema.mapper.PedidoMapper;
import com.marcos.pizzaria_sistema.model.Pedido;
import com.marcos.pizzaria_sistema.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@PostMapping
	public ResponseEntity<PedidoResponseDto> create(@Valid @RequestBody PedidoCreateDto dto) {
		Pedido cat = PedidoMapper.toPedido(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(PedidoMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoResponseDto> findById(@Valid @PathVariable Long id) {
		Pedido cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(PedidoMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<PedidoResponseDto>> findAll() {
		List<Pedido> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(PedidoMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody PedidoCreateDto dto) {
		Pedido cat = PedidoMapper.toPedido(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(PedidoMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
