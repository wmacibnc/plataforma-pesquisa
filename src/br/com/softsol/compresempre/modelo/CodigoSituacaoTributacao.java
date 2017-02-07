package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CodigoSituacaoTributacao {

	// Váriaveis

	@Id
	@GeneratedValue
	private Long id;
	private String codigo;
	private String nome;

	// Relacionamentos

	// Relacionamento com Regime Tributacao
	@ManyToOne
	@JoinColumn(name = "cod_regimeTributacao")
	private RegimeTributacao regimeTributacao;

	// Relacionamento com ProdutoEmpresa
	@OneToMany(mappedBy = "codigoSituacaoTributacao", targetEntity = ProdutoEmpresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProdutoEmpresa> produtoEmpresas;

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RegimeTributacao getRegimeTributacao() {
		return regimeTributacao;
	}

	public void setRegimeTributacao(RegimeTributacao regimeTributacao) {
		this.regimeTributacao = regimeTributacao;
	}

	public List<ProdutoEmpresa> getProdutoEmpresas() {
		return produtoEmpresas;
	}

	public void setProdutoEmpresas(List<ProdutoEmpresa> produtoEmpresas) {
		this.produtoEmpresas = produtoEmpresas;
	}

}
