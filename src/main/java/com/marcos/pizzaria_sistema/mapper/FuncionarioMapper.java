package com.marcos.pizzaria_sistema.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.marcos.pizzaria_sistema.dto.FuncionarioCreateDto;
import com.marcos.pizzaria_sistema.dto.FuncionarioResponseDto;
import com.marcos.pizzaria_sistema.model.Funcionario;

public class FuncionarioMapper {

	public static Funcionario toFuncionario(FuncionarioCreateDto dto) {
		return new ModelMapper().map(dto, Funcionario.class);
	}

	public static FuncionarioResponseDto toDto(Funcionario func) {
		return new ModelMapper().map(func, FuncionarioResponseDto.class);
	}
	
	public static List<FuncionarioResponseDto> toListDto(List<Funcionario> func){
		return func.stream().map(cats -> toDto(cats)).collect(Collectors.toList());
	}

}
