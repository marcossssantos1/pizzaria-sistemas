package com.marcos.pizzaria_sistema.dto;

import com.marcos.pizzaria_sistema.model.Endereco;

import jakarta.validation.constraints.NotBlank;

public class ClienteResponseDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;

	private Endereco endereco;

	public ClienteResponseDto() {
	}

	public ClienteResponseDto(@NotBlank String nome, @NotBlank String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}

	public ClienteResponseDto(@NotBlank String nome, @NotBlank String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
