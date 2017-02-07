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

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class Subgrupo {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	// Relacionamento com Grupo
	@ManyToOne
	@JoinColumn(name = "cod_grupo")
	private Grupo grupo;

	// Relacionamento com produto
	@OneToMany(mappedBy = "subgrupo", targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Produto> produto;

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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
