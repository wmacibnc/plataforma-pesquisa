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
public class Produto {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private String fabricante;
	private String ncmsh;
	private String nome;
	private String codantigo;
	private String data;
	private double preço;
	private String unidade;
	private String aplicacao;
	private String extipi;
	private String genero;

	// Relacionamento com Subgrupo
	@ManyToOne
	@JoinColumn(name = "cod_subgrupo")
	private Subgrupo subgrupo;

	// Relacionamento com ProdutoEmpresa
	@OneToMany(mappedBy = "produto", targetEntity = ProdutoEmpresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProdutoEmpresa> produtoEmpresa;

	// Relacionamento com Produtos em Destaque
	@OneToMany(mappedBy = "produto", targetEntity = ProdutoDestaque.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProdutoDestaque> produtoDestaque;

	// Relacionamento com Fornecedor
	@ManyToOne
	@JoinColumn(name = "cod_fornecedor")
	private Fornecedor fornecedor;

	// Relacionamento com CodigoFiscalOperacoesPrestacoes
	@ManyToOne
	@JoinColumn(name = "cod_codigoFiscalOperacoesPrestacoes")
	private CodigoFiscalOperacoesPrestacoes codigoFiscalOperacoesPrestacoes;

	// Relacionamento com TipoProduto
	@ManyToOne
	@JoinColumn(name = "cod_tipoProduto")
	private TipoProduto tipoProduto;

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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Subgrupo getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	public String getCodantigo() {
		return codantigo;
	}

	public void setCodantigo(String codantigo) {
		this.codantigo = codantigo;
	}

	public List<ProdutoEmpresa> getProdutoEmpresa() {
		return produtoEmpresa;
	}

	public void setProdutoEmpresa(List<ProdutoEmpresa> produtoEmpresa) {
		this.produtoEmpresa = produtoEmpresa;
	}

	public String getNcmsh() {
		return ncmsh;
	}

	public void setNcmsh(String ncmsh) {
		this.ncmsh = ncmsh;
	}

	public List<ProdutoDestaque> getProdutoDestaque() {
		return produtoDestaque;
	}

	public void setProdutoDestaque(List<ProdutoDestaque> produtoDestaque) {
		this.produtoDestaque = produtoDestaque;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getExtipi() {
		return extipi;
	}

	public void setExtipi(String extipi) {
		this.extipi = extipi;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CodigoFiscalOperacoesPrestacoes getCodigoFiscalOperacoesPrestacoes() {
		return codigoFiscalOperacoesPrestacoes;
	}

	public void setCodigoFiscalOperacoesPrestacoes(
			CodigoFiscalOperacoesPrestacoes codigoFiscalOperacoesPrestacoes) {
		this.codigoFiscalOperacoesPrestacoes = codigoFiscalOperacoesPrestacoes;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}
