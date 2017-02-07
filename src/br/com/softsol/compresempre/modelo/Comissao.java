package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comissao {

	// Váriaveis

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private double valor;

	// Relacionamentos

	// Relacionamento com ProdutoEmpresa
	@OneToMany(mappedBy = "comissao", targetEntity = ProdutoEmpresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProdutoEmpresa> produtoEmpresa;

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<ProdutoEmpresa> getProdutoEmpresa() {
		return produtoEmpresa;
	}

	public void setProdutoEmpresa(List<ProdutoEmpresa> produtoEmpresa) {
		this.produtoEmpresa = produtoEmpresa;
	}

}
