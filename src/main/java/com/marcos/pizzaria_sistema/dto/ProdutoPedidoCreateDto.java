package com.marcos.pizzaria_sistema.dto;

import com.marcos.pizzaria_sistema.model.Produto;

public class ProdutoPedidoCreateDto {

	private int quantidade;
	private String observacao;
	private Produto produto;

	public ProdutoPedidoCreateDto() {
	}

	public ProdutoPedidoCreateDto(int quantidade, String observacao, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.observacao = observacao;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
