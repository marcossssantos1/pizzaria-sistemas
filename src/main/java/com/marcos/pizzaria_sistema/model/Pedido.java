package com.marcos.pizzaria_sistema.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "valor", nullable = false)
	private double valor;
	@Column(name = "forma_pagamento", nullable = false)
	private int forma_pagamento;
	@Column(name = "data_hora", nullable = false)
	private Date dataHora;
	@Column(name = "status", nullable = false)
	private int status;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;
	@OneToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	@OneToOne
	@JoinColumn(name = "produtos_id", nullable = false)
	private ProdutoPedido produtos;

	public Pedido() {
	}

	public Pedido(Long id, double valor, int forma_pagamento, Date dataHora, int status, Cliente cliente,
			Endereco endereco, Funcionario funcionario, ProdutoPedido produtos) {
		super();
		this.id = id;
		this.valor = valor;
		this.forma_pagamento = forma_pagamento;
		this.dataHora = dataHora;
		this.status = status;
		this.cliente = cliente;
		this.endereco = endereco;
		this.funcionario = funcionario;
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ProdutoPedido getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdutoPedido produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
