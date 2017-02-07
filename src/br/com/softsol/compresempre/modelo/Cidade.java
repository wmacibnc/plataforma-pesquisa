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
public class Cidade {
	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String codigo;
	// Relacionamento com Estado
	@ManyToOne
	@JoinColumn(name = "cod_estado")
	private Estado estado;

	// Relacionamento com Bairro
	@OneToMany(mappedBy = "cidade", targetEntity = Bairro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bairro> bairro;

	// Métodos set e get

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Bairro> getBairro() {
		return bairro;
	}

	public void setBairro(List<Bairro> bairro) {
		this.bairro = bairro;
	}

}
