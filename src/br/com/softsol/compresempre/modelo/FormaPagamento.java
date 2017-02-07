package br.com.softsol.compresempre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Entity
public class FormaPagamento {

	// Váriavéis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private int parcelas_semjuros;
	private int parcelas_comjuros;
	private double porcetagem;

	/*
	 * //Relacionamento com Orcamento
	 * 
	 * @OneToMany(mappedBy = "formaPagamento",targetEntity= Orcamento.class,
	 * fetch = FetchType.LAZY, cascade = CascadeType.ALL) private
	 * List<Orcamento> orcamento ;
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

	public int getParcelas_semjuros() {
		return parcelas_semjuros;
	}

	public void setParcelas_semjuros(int parcelas_semjuros) {
		this.parcelas_semjuros = parcelas_semjuros;
	}

	public int getParcelas_comjuros() {
		return parcelas_comjuros;
	}

	public void setParcelas_comjuros(int parcelas_comjuros) {
		this.parcelas_comjuros = parcelas_comjuros;
	}

	public double getPorcetagem() {
		return porcetagem;
	}

	public void setPorcetagem(double porcetagem) {
		this.porcetagem = porcetagem;
	}

}
