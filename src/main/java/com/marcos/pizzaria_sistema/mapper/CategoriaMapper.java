package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.CategoriaCrateDto;
import com.marcos.pizzaria_sistema.dto.CategoriaResponseDto;
import com.marcos.pizzaria_sistema.model.Categoria;

public class CategoriaMapper {

	public static Categoria toCategoria(CategoriaCrateDto dto) {
		return new ModelMapper().map(dto, Categoria.class);
	}

	public static CategoriaResponseDto toDto(Categoria cat) {
		return new ModelMapper().map(cat, CategoriaResponseDto.class);
	}
	
	public static List<CategoriaResponseDto> toListDto(List<Categoria> cat){
		return cat.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}

}
