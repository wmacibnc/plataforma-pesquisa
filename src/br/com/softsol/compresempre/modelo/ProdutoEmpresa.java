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
 * @last update 29/01/2013
 */

@Entity
public class ProdutoEmpresa {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private String quantidade_estoque;
	private double preco;
	private String ativo;
	// Inclusão para Softsol Web
	private String codprodutofabricante;
	private String codbarra;
	private String observacao;
	private String gramatura;
	private int quantidadedevenda;
	private int unidadeconsumo;
	private String imprimilivro;
	private double precocusto;
	private double ipiporcentagem;
	// private double ipivalor-mostrar;
	private double descontonanotafiscalporcentagem;
	// private double descontonotafiscalvalor - mostrar;
	private double icmsporcentagem;
	// private double icmsvalor - mostrar;
	// mostrar na tela o valor total - não precisa criar a váriavel

	private double freteporcentagem;
	// private double fretevalor - mostrar - pe;
	private double impostosporcentagem;
	private double despesasfixas;
	private double despesasvariaveis;
	private double custoliquido;
	private double margemdelucroporcentagem;
	// private double margemdelucrovalor;
	private double precofaturado;
	private double precovenda;
	private double precovendaminimoepromocao;
	private double precovendaatacado;
	private String controlaestoque;
	private String tributacao;

	// Relacionamento com Produto
	@ManyToOne
	@JoinColumn(name = "cod_produto")
	private Produto produto;

	// Relacionamento com Empresa
	@ManyToOne
	@JoinColumn(name = "cod_empresa")
	private Empresa empresa;

	// Relacionamento com Item
	@OneToMany(mappedBy = "produtoEmpresa", targetEntity = Item.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> item;

	// Relacionamento com Comissao
	@ManyToOne
	@JoinColumn(name = "cod_comissao")
	private Comissao comissao;

	// Relacionamento com CodigoSituacaoTributacao
	@ManyToOne
	@JoinColumn(name = "cod_codigoSituacaoTributacao")
	private CodigoSituacaoTributacao codigoSituacaoTributacao;

	// Relacionamento com UnidadeEstoque
	@ManyToOne
	@JoinColumn(name = "cod_unidadeEstoque")
	private UnidadeEstoque unidadeEstoque;

	// Método set e get

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(String quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String getCodprodutofabricante() {
		return codprodutofabricante;
	}

	public void setCodprodutofabricante(String codprodutofabricante) {
		this.codprodutofabricante = codprodutofabricante;
	}

	public String getCodbarra() {
		return codbarra;
	}

	public void setCodbarra(String codbarra) {
		this.codbarra = codbarra;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getGramatura() {
		return gramatura;
	}

	public void setGramatura(String gramatura) {
		this.gramatura = gramatura;
	}

	public int getQuantidadedevenda() {
		return quantidadedevenda;
	}

	public void setQuantidadedevenda(int quantidadedevenda) {
		this.quantidadedevenda = quantidadedevenda;
	}

	public int getUnidadeconsumo() {
		return unidadeconsumo;
	}

	public void setUnidadeconsumo(int unidadeconsumo) {
		this.unidadeconsumo = unidadeconsumo;
	}

	public String getImprimilivro() {
		return imprimilivro;
	}

	public void setImprimilivro(String imprimilivro) {
		this.imprimilivro = imprimilivro;
	}

	public double getPrecocusto() {
		return precocusto;
	}

	public void setPrecocusto(double precocusto) {
		this.precocusto = precocusto;
	}

	public double getIpiporcentagem() {
		return ipiporcentagem;
	}

	public void setIpiporcentagem(double ipiporcentagem) {
		this.ipiporcentagem = ipiporcentagem;
	}

	public double getDescontonanotafiscalporcentagem() {
		return descontonanotafiscalporcentagem;
	}

	public void setDescontonanotafiscalporcentagem(
			double descontonanotafiscalporcentagem) {
		this.descontonanotafiscalporcentagem = descontonanotafiscalporcentagem;
	}

	public double getIcmsporcentagem() {
		return icmsporcentagem;
	}

	public void setIcmsporcentagem(double icmsporcentagem) {
		this.icmsporcentagem = icmsporcentagem;
	}

	public double getFreteporcentagem() {
		return freteporcentagem;
	}

	public void setFreteporcentagem(double freteporcentagem) {
		this.freteporcentagem = freteporcentagem;
	}

	public double getImpostosporcentagem() {
		return impostosporcentagem;
	}

	public void setImpostosporcentagem(double impostosporcentagem) {
		this.impostosporcentagem = impostosporcentagem;
	}

	public double getDespesasfixas() {
		return despesasfixas;
	}

	public void setDespesasfixas(double despesasfixas) {
		this.despesasfixas = despesasfixas;
	}

	public double getDespesasvariaveis() {
		return despesasvariaveis;
	}

	public void setDespesasvariaveis(double despesasvariaveis) {
		this.despesasvariaveis = despesasvariaveis;
	}

	public double getCustoliquido() {
		return custoliquido;
	}

	public void setCustoliquido(double custoliquido) {
		this.custoliquido = custoliquido;
	}

	public double getMargemdelucroporcentagem() {
		return margemdelucroporcentagem;
	}

	public void setMargemdelucroporcentagem(double margemdelucroporcentagem) {
		this.margemdelucroporcentagem = margemdelucroporcentagem;
	}

	public double getPrecofaturado() {
		return precofaturado;
	}

	public void setPrecofaturado(double precofaturado) {
		this.precofaturado = precofaturado;
	}

	public double getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(double precovenda) {
		this.precovenda = precovenda;
	}

	public double getPrecovendaminimoepromocao() {
		return precovendaminimoepromocao;
	}

	public void setPrecovendaminimoepromocao(double precovendaminimoepromocao) {
		this.precovendaminimoepromocao = precovendaminimoepromocao;
	}

	public double getPrecovendaatacado() {
		return precovendaatacado;
	}

	public void setPrecovendaatacado(double precovendaatacado) {
		this.precovendaatacado = precovendaatacado;
	}

	public String getControlaestoque() {
		return controlaestoque;
	}

	public void setControlaestoque(String controlaestoque) {
		this.controlaestoque = controlaestoque;
	}

	public String getTributacao() {
		return tributacao;
	}

	public void setTributacao(String tributacao) {
		this.tributacao = tributacao;
	}

	public Comissao getComissao() {
		return comissao;
	}

	public void setComissao(Comissao comissao) {
		this.comissao = comissao;
	}

	public CodigoSituacaoTributacao getCodigoSituacaoTributacao() {
		return codigoSituacaoTributacao;
	}

	public void setCodigoSituacaoTributacao(
			CodigoSituacaoTributacao codigoSituacaoTributacao) {
		this.codigoSituacaoTributacao = codigoSituacaoTributacao;
	}

	public UnidadeEstoque getUnidadeEstoque() {
		return unidadeEstoque;
	}

	public void setUnidadeEstoque(UnidadeEstoque unidadeEstoque) {
		this.unidadeEstoque = unidadeEstoque;
	}

}
