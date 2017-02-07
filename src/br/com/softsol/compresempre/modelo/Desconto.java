package br.com.softsol.compresempre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class Desconto {
	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private double valor;

	// Relacionamento com Empresa
	/*
	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa empresa;
	*/

	// Método set e get
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
