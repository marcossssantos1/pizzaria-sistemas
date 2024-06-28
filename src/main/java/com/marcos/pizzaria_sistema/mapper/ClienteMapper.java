package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.ClienteCreateDto;
import com.marcos.pizzaria_sistema.dto.ClienteResponseDto;
import com.marcos.pizzaria_sistema.model.Cliente;

public class ClienteMapper {

	public static Cliente toCliente(ClienteCreateDto dto) {
		return new ModelMapper().map(dto, Cliente.class);
	}

	public static ClienteResponseDto toDto(Cliente cat) {
		return new ModelMapper().map(cat, ClienteResponseDto.class);
	}
	
	public static List<ClienteResponseDto> toListDto(List<Cliente> cat){
		return cat.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}

}
