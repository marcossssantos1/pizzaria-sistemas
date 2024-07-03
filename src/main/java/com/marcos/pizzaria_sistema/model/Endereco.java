package com.marcos.pizzaria_sistema.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name = "rua")
	private String rua;
	@Column(name = "numero")
	private int numero;
	@NotBlank
	@Column(name = "referencia")
	private String referencia;

	@OneToOne(mappedBy = "endereco")
	private Cliente clientes;
	
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Pedido pedido;

	public Endereco() {
	}

	public Endereco(Long id, @NotBlank String rua, int numero, @NotBlank String referencia) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.referencia = referencia;
	}

	public Endereco(Long id, @NotBlank String rua, int numero, @NotBlank String referencia, Cliente clientes) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.referencia = referencia;
		this.clientes = clientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

}
