package com.marcos.pizzaria_sistema.dto;

import com.marcos.pizzaria_sistema.model.Cliente;

import jakarta.validation.constraints.NotBlank;

public class EnderecoCreateDto {

	@NotBlank
	private String rua;
	private int numero;
	@NotBlank
	private String referencia;

	private Cliente clientes;

	public EnderecoCreateDto() {
	}

	public EnderecoCreateDto(@NotBlank String rua, int numero, @NotBlank String referencia, Cliente clientes) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.referencia = referencia;
		this.clientes = clientes;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

}
