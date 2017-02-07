package br.com.softsol.compresempre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class Item {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private int quantidade;
	private double preco_unit;
	private double preco_total;

	// Relacionamento com ProdutoEmpresa
	@ManyToOne
	@JoinColumn(name = "cod_produtoempresa")
	private ProdutoEmpresa produtoEmpresa;

	// Relacionamento com Orçamento
	@ManyToOne
	@JoinColumn(name = "cod_orcamento")
	private Orcamento orcamento;

	// Método set e get
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco_unit() {
		return preco_unit;
	}

	public void setPreco_unit(double preco_unit) {
		this.preco_unit = preco_unit;
	}

	public double getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(double preco_total) {
		this.preco_total = preco_total;
	}

	public ProdutoEmpresa getProdutoEmpresa() {
		return produtoEmpresa;
	}

	public void setProdutoEmpresa(ProdutoEmpresa produtoEmpresa) {
		this.produtoEmpresa = produtoEmpresa;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}
