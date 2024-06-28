package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.ProdutoCreateDto;
import com.marcos.pizzaria_sistema.dto.ProdutoResponseDto;
import com.marcos.pizzaria_sistema.model.Produto;

public class ProdutoMapper {

	public static Produto toProduto(ProdutoCreateDto dto) {
		return new ModelMapper().map(dto, Produto.class);
	}
	
	public static ProdutoResponseDto toDto(Produto prod) {
		return new ModelMapper().map(prod, ProdutoResponseDto.class);
	}
	
	public static List<ProdutoResponseDto> toListDto(List<Produto> prod){
		return prod.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}
	
}
