package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.IngredientesCreateDto;
import com.marcos.pizzaria_sistema.dto.IngredientesResponseDto;
import com.marcos.pizzaria_sistema.model.Ingredientes;

public class IngredientesMapper {

	public static Ingredientes toIngredientes(IngredientesCreateDto dto) {
		return new ModelMapper().map(dto, Ingredientes.class);
	}
	
	public static IngredientesResponseDto toDto(Ingredientes ingredientes) {
		return new ModelMapper().map(ingredientes, IngredientesResponseDto.class);
	}
	
	public static List<IngredientesResponseDto> toListDto(List<Ingredientes> ingrediente){
		return ingrediente.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}
	
}
