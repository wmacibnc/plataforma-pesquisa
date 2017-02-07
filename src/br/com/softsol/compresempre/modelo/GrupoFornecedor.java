package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GrupoFornecedor {

	// variaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	// Relacionamento com Fornecedor
	@OneToMany(mappedBy = "grupoFornecedor", targetEntity = Fornecedor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fornecedor> fornecedor;

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

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

}
