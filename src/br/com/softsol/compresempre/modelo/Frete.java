package br.com.softsol.compresempre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class Frete {
	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String valor;

	/*
	 * Relacionamento com Orcamento
	 * 
	 * @OneToMany(mappedBy = "frete",targetEntity= Orcamento.class, fetch =
	 * FetchType.LAZY, cascade = CascadeType.ALL) private List<Orcamento>
	 * orcamento ;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
