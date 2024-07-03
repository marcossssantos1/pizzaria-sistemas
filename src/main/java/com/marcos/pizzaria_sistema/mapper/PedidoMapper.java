package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.PedidoCreateDto;
import com.marcos.pizzaria_sistema.dto.PedidoResponseDto;
import com.marcos.pizzaria_sistema.model.Pedido;

public class PedidoMapper {

	public static Pedido toPedido(PedidoCreateDto dto) {
		return new ModelMapper().map(dto, Pedido.class);
	}

	public static PedidoResponseDto toDto(Pedido ped) {
		return new ModelMapper().map(ped, PedidoResponseDto.class);
	}
	
	public static List<PedidoResponseDto> toListDto(List<Pedido> ped){
		return ped.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}

}
