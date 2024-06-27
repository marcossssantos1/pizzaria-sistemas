package com.marcos.pizzaria_sistema.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaResponseDto {

	@NotBlank
	private String nome;

	public CategoriaResponseDto() {
	}

	public CategoriaResponseDto(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
