package com.marcos.pizzaria_sistema.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaCrateDto {

	@NotBlank
	private String nome;

	public CategoriaCrateDto() {
	}

	public CategoriaCrateDto(@NotBlank String nome) {
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
