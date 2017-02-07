package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CodigoFiscalOperacoesPrestacoes {

	// Váriaveis

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String tipo_mov;
	private String cfop_f;
	private String cfop_3;
	private String codigo;

	// Relacionamentos

	// Relacionamento com Produto
	@OneToMany(mappedBy = "codigoFiscalOperacoesPrestacoes", targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Produto> produto;

	// Getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo_mov() {
		return tipo_mov;
	}

	public void setTipo_mov(String tipo_mov) {
		this.tipo_mov = tipo_mov;
	}

	public String getCfop_f() {
		return cfop_f;
	}

	public void setCfop_f(String cfop_f) {
		this.cfop_f = cfop_f;
	}

	public String getCfop_3() {
		return cfop_3;
	}

	public void setCfop_3(String cfop_3) {
		this.cfop_3 = cfop_3;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

}
