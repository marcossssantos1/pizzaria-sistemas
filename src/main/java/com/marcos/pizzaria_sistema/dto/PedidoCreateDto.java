package com.marcos.pizzaria_sistema.dto;

import java.util.Date;
import java.util.List;

import com.marcos.pizzaria_sistema.model.Cliente;
import com.marcos.pizzaria_sistema.model.Endereco;
import com.marcos.pizzaria_sistema.model.Funcionario;
import com.marcos.pizzaria_sistema.model.ProdutoPedido;

public class PedidoCreateDto {

	private double valor;
	private int forma_pagamento;
	private Date dataHora;
	private int status;

	private Cliente cliente;
	private Endereco endereco;
	private Funcionario funcionario;
	private List<ProdutoPedido> produtos;

	public PedidoCreateDto() {
	}

	public PedidoCreateDto(double valor, int forma_pagamento, Date dataHora, int status, Cliente cliente,
			Endereco endereco, Funcionario funcionario, List<ProdutoPedido> produtos) {
		super();
		this.valor = valor;
		this.forma_pagamento = forma_pagamento;
		this.dataHora = dataHora;
		this.status = status;
		this.cliente = cliente;
		this.endereco = endereco;
		this.funcionario = funcionario;
		this.produtos = produtos;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(int forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ProdutoPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoPedido> produtos) {
		this.produtos = produtos;
	}

}
