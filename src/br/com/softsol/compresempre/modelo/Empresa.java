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
public class Empresa {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private String fantasia;
	private String razao;
	private String cnpj;
	private String inscricao_estadual;
	private String proprietario;
	private String login;
	private String senha;
	private String situacao;
	private String data_cadastro;
	private String hora_cadastro;
	private String endereco;
	private String cep;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private String email;
	private String fax;
	private String site;
	private String loja;
	private double porcentagemloja;

	// Relacionamento com Bairro
	@ManyToOne
	@JoinColumn(name = "cod_bairro")
	private Bairro bairro;

	// Relacionamento com Atividade
	@ManyToOne
	@JoinColumn(name = "cod_atividade")
	private Atividade atividade;

	// Relacionamento com ProdutoEmpresa
	@OneToMany(mappedBy = "empresa", targetEntity = ProdutoEmpresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProdutoEmpresa> produtoEmpresa;

	// Método set e get
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getHora_cadastro() {
		return hora_cadastro;
	}

	public void setHora_cadastro(String hora_cadastro) {
		this.hora_cadastro = hora_cadastro;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<ProdutoEmpresa> getProdutoEmpresa() {
		return produtoEmpresa;
	}

	public void setProdutoEmpresa(List<ProdutoEmpresa> produtoEmpresa) {
		this.produtoEmpresa = produtoEmpresa;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public double getPorcentagemloja() {
		return porcentagemloja;
	}

	public void setPorcentagemloja(double porcentagemloja) {
		this.porcentagemloja = porcentagemloja;
	}

	

}
