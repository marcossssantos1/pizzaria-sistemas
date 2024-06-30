package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.ProdutoPedidoCreateDto;
import com.marcos.pizzaria_sistema.dto.ProdutoPedidoResponseDto;
import com.marcos.pizzaria_sistema.model.ProdutoPedido;

public class ProdutoPedidoMapper {

	public static ProdutoPedido toProdutoPedido(ProdutoPedidoCreateDto dto) {
		return new ModelMapper().map(dto, ProdutoPedido.class);
	}

	public static ProdutoPedidoResponseDto toDto(ProdutoPedido cat) {
		return new ModelMapper().map(cat, ProdutoPedidoResponseDto.class);
	}
	
	public static List<ProdutoPedidoResponseDto> toListDto(List<ProdutoPedido> cat){
		return cat.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}

}
