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
public class Atividade {

	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	// Relacionamento com Empresa
	@OneToMany(mappedBy = "atividade", targetEntity = Empresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Empresa> empresa;

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

	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}

}
