package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class Grupo {
	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	// Relacionamento com Subgrupo
	@OneToMany(mappedBy = "grupo", targetEntity = Subgrupo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Subgrupo> subgrupo;

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

	public List<Subgrupo> getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(List<Subgrupo> subgrupo) {
		this.subgrupo = subgrupo;
	}

}
