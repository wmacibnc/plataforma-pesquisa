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
public class Bairro {

	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String codigo;

	// Relacionamento com Empresa
	@OneToMany(mappedBy = "bairro", targetEntity = Empresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Empresa> empresa;

	// Relacionamento com Usuário
	@OneToMany(mappedBy = "bairro", targetEntity = Usuario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Usuario> usuario;

	// Relacionamento com Cidade
	@ManyToOne
	@JoinColumn(name = "cod_cidade")
	private Cidade cidade;
	
	// Relacionamento com Fornecedor
		@OneToMany(mappedBy = "bairro", targetEntity = Fornecedor.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<Fornecedor> fornecedor;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}

}
