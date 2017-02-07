package br.com.softsol.compresempre.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @LastUpdate 31/01/2013
  */

@Entity
public class Fornecedor {
	//Váriaveis
	@Id
	@GeneratedValue
	private long id;
	//Razão social
	private String deno_qua;
	//Nome Fantasia
	private String deno_vin;
	private String endereco;
	private String cidade;
	private String cep;
	private String ddd;
	private String telefone;
	//Telefone3
	private String telex;
	private String fax;
	private String cod_sit;
	private String fabricante;
	private String cgc;
	private String ins_est;
	private String contato;
	private String bairro_end;
	private String cx_postal_end;
	private String fone2_end;
	private String rua_pgto;
	private String bairro_pgto;
	private String cidade_pgto;
	private String cx_postal_pgto;
	private String cep_pgto;
	private String fone1_pgto;
	private String fone2_pgto;
	//Telefone 3 de Pagamento
	private String telex_pgto;
	//Fax para Pagamento
	private String fac_pgto;
	private String banco;
	private String agencia;
	//Chave - retirar
	private String chave_age;
	private String conta_corrente;
	private String icms;
	private String www;
	private String e_mail;
	//Retirar
	private String qt_linha;
	private String dt_ult_compra;
	//data de inclusão
	private String inc_dat;
	//Nome do usuário que incluiu
	private String inc_resp;
	//Hora da inclusão
	private String inc_hor;
	//Data da alteração
	private String alt_dat;
	//Pessoa que alterou
	private String alt_resp;
	//Hora que alterou
	private String alt_hor;
	private String vendedor;
	private String telefone2;
	private String grupo;

	
	//Construtor
	public Fornecedor(){
		// Hora e data
		Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = sdf.format(dataAtual);
		this.setInc_dat(dataStr);
		
		Date horaAtual = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
		String horaStr = sdf2.format(horaAtual);
		this.setInc_hor(horaStr);	
	}
	// Relacionamentos

	// Relacionamento com Produto
	@OneToMany(mappedBy = "fornecedor", targetEntity = Produto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Produto> produto;

	// Relacionamento com Grupo Fornecedor
	@ManyToOne
	@JoinColumn(name = "cod_grupoFornecedor")
	private GrupoFornecedor grupoFornecedor;

	// Relacionamento com Bairro
	@ManyToOne
	@JoinColumn(name = "cod_bairro")
	private Bairro bairro;

	// Getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeno_qua() {
		return deno_qua;
	}

	public void setDeno_qua(String deno_qua) {
		this.deno_qua = deno_qua;
	}

	public String getDeno_vin() {
		return deno_vin;
	}

	public void setDeno_vin(String deno_vin) {
		this.deno_vin = deno_vin;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelex() {
		return telex;
	}

	public void setTelex(String telex) {
		this.telex = telex;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCod_sit() {
		return cod_sit;
	}

	public void setCod_sit(String cod_sit) {
		this.cod_sit = cod_sit;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCgc() {
		return cgc;
	}

	public void setCgc(String cgc) {
		this.cgc = cgc;
	}

	public String getIns_est() {
		return ins_est;
	}

	public void setIns_est(String ins_est) {
		this.ins_est = ins_est;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getBairro_end() {
		return bairro_end;
	}

	public void setBairro_end(String bairro_end) {
		this.bairro_end = bairro_end;
	}

	public String getCx_postal_end() {
		return cx_postal_end;
	}

	public void setCx_postal_end(String cx_postal_end) {
		this.cx_postal_end = cx_postal_end;
	}

	public String getFone2_end() {
		return fone2_end;
	}

	public void setFone2_end(String fone2_end) {
		this.fone2_end = fone2_end;
	}

	public String getRua_pgto() {
		return rua_pgto;
	}

	public void setRua_pgto(String rua_pgto) {
		this.rua_pgto = rua_pgto;
	}

	public String getBairro_pgto() {
		return bairro_pgto;
	}

	public void setBairro_pgto(String bairro_pgto) {
		this.bairro_pgto = bairro_pgto;
	}

	public String getCidade_pgto() {
		return cidade_pgto;
	}

	public void setCidade_pgto(String cidade_pgto) {
		this.cidade_pgto = cidade_pgto;
	}

	public String getCx_postal_pgto() {
		return cx_postal_pgto;
	}

	public void setCx_postal_pgto(String cx_postal_pgto) {
		this.cx_postal_pgto = cx_postal_pgto;
	}

	public String getCep_pgto() {
		return cep_pgto;
	}

	public void setCep_pgto(String cep_pgto) {
		this.cep_pgto = cep_pgto;
	}

	public String getFone1_pgto() {
		return fone1_pgto;
	}

	public void setFone1_pgto(String fone1_pgto) {
		this.fone1_pgto = fone1_pgto;
	}

	public String getFone2_pgto() {
		return fone2_pgto;
	}

	public void setFone2_pgto(String fone2_pgto) {
		this.fone2_pgto = fone2_pgto;
	}

	public String getTelex_pgto() {
		return telex_pgto;
	}

	public void setTelex_pgto(String telex_pgto) {
		this.telex_pgto = telex_pgto;
	}

	public String getFac_pgto() {
		return fac_pgto;
	}

	public void setFac_pgto(String fac_pgto) {
		this.fac_pgto = fac_pgto;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getChave_age() {
		return chave_age;
	}

	public void setChave_age(String chave_age) {
		this.chave_age = chave_age;
	}

	public String getConta_corrente() {
		return conta_corrente;
	}

	public void setConta_corrente(String conta_corrente) {
		this.conta_corrente = conta_corrente;
	}

	public String getIcms() {
		return icms;
	}

	public void setIcms(String icms) {
		this.icms = icms;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getQt_linha() {
		return qt_linha;
	}

	public void setQt_linha(String qt_linha) {
		this.qt_linha = qt_linha;
	}

	public String getDt_ult_compra() {
		return dt_ult_compra;
	}

	public void setDt_ult_compra(String dt_ult_compra) {
		this.dt_ult_compra = dt_ult_compra;
	}

	public String getInc_dat() {
		return inc_dat;
	}

	public void setInc_dat(String inc_dat) {
		this.inc_dat = inc_dat;
	}

	public String getInc_resp() {
		return inc_resp;
	}

	public void setInc_resp(String inc_resp) {
		this.inc_resp = inc_resp;
	}

	public String getInc_hor() {
		return inc_hor;
	}

	public void setInc_hor(String inc_hor) {
		this.inc_hor = inc_hor;
	}

	public String getAlt_dat() {
		return alt_dat;
	}

	public void setAlt_dat(String alt_dat) {
		this.alt_dat = alt_dat;
	}

	public String getAlt_resp() {
		return alt_resp;
	}

	public void setAlt_resp(String alt_resp) {
		this.alt_resp = alt_resp;
	}

	public String getAlt_hor() {
		return alt_hor;
	}

	public void setAlt_hor(String alt_hor) {
		this.alt_hor = alt_hor;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public GrupoFornecedor getGrupoFornecedor() {
		return grupoFornecedor;
	}

	public void setGrupoFornecedor(GrupoFornecedor grupoFornecedor) {
		this.grupoFornecedor = grupoFornecedor;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}
