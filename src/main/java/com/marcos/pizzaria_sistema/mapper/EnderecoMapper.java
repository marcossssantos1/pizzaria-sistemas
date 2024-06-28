package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.EnderecoCreateDto;
import com.marcos.pizzaria_sistema.dto.EnderecoResponseDto;
import com.marcos.pizzaria_sistema.model.Endereco;

public class EnderecoMapper {

	public static Endereco toEndereco(EnderecoCreateDto dto) {
		return new ModelMapper().map(dto, Endereco.class);
	}

	public static EnderecoResponseDto toDto(Endereco cat) {
		return new ModelMapper().map(cat, EnderecoResponseDto.class);
	}
	
	public static List<EnderecoResponseDto> toListDto(List<Endereco> cat){
		return cat.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}

}
