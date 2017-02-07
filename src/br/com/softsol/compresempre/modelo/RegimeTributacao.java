package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RegimeTributacao {

	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	// Relacionamentos

	// Relacionamento com CodigoSituacaoTributacao
	@OneToMany(mappedBy = "regimeTributacao", targetEntity = CodigoSituacaoTributacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CodigoSituacaoTributacao> codigoSituacaoTributacao;

	// Getters and setters

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

	public List<CodigoSituacaoTributacao> getCodigoSituacaoTributacao() {
		return codigoSituacaoTributacao;
	}

	public void setCodigoSituacaoTributacao(
			List<CodigoSituacaoTributacao> codigoSituacaoTributacao) {
		this.codigoSituacaoTributacao = codigoSituacaoTributacao;
	}

}
