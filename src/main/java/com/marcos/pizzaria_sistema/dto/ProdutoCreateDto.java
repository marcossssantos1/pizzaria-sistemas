package com.marcos.pizzaria_sistema.dto;

import com.marcos.pizzaria_sistema.model.Categoria;
import com.marcos.pizzaria_sistema.model.Ingredientes;

import jakarta.validation.constraints.NotBlank;

public class ProdutoCreateDto {

	private int codigo;
	@NotBlank
	private String nome;
	private Double preco;

	private Categoria categoria;

	private Ingredientes ingredientes;

	public ProdutoCreateDto() {
	}

	public ProdutoCreateDto(int codigo, @NotBlank String nome, Double preco, Categoria categoria,
			Ingredientes ingredientes) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Ingredientes getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Ingredientes ingredientes) {
		this.ingredientes = ingredientes;
	}

}
