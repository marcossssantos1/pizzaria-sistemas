package com.marcos.pizzaria_sistema.dto;

import jakarta.validation.constraints.NotBlank;

public class FuncionarioResponseDto {

	private int registro;
	@NotBlank
	private String nome;
	@NotBlank
	private String senha;

	public FuncionarioResponseDto() {
	}

	public FuncionarioResponseDto(int registro, @NotBlank String nome, @NotBlank String senha) {
		super();
		this.registro = registro;
		this.nome = nome;
		this.senha = senha;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
