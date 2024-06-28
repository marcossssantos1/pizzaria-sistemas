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

import com.marcos.pizzaria_sistema.dto.ClienteCreateDto;
import com.marcos.pizzaria_sistema.dto.ClienteResponseDto;
import com.marcos.pizzaria_sistema.mapper.ClienteMapper;
import com.marcos.pizzaria_sistema.model.Cliente;
import com.marcos.pizzaria_sistema.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<ClienteResponseDto> create(@Valid @RequestBody ClienteCreateDto dto) {
		Cliente cat = ClienteMapper.toCliente(dto);
		service.create(cat);
		return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toDto(cat));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponseDto> findById(@Valid @PathVariable Long id) {
		Cliente cat = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toDto(cat));
	}

	@GetMapping
	public ResponseEntity<List<ClienteResponseDto>> findAll() {
		List<Cliente> cat = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toListDto(cat));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDto> update(@Valid @PathVariable Long id,
			@Valid @RequestBody ClienteCreateDto dto) {
		Cliente cat = ClienteMapper.toCliente(dto);
		cat = service.update(id, cat);
		cat = service.findById(cat.getId());
		return ResponseEntity.status(HttpStatus.OK).body(ClienteMapper.toDto(cat));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
