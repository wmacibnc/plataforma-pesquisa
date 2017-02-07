package br.com.softsol.compresempre.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class MenorPreco {

	// Variaveis
	@Id
	@GeneratedValue
	private Long id;
	private Long empresa;
	private Long produto;
	private Long localidade;
	private String tipo;
	private String data;
	private String hora;
	private String ip;

	// Método construtor
	public MenorPreco(HttpServletRequest request) {
		// Hora e data
		Date dataAtual = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
		String hora = sdf1.format(dataAtual);
		String data = sdf2.format(dataAtual);
		this.setData(data);
		this.setHora(hora);

		// setando ip
		this.setIp(request.getHeader("X-FORWARDED-FOR"));

	}

	// Método set e get

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public Long getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Long localidade) {
		this.localidade = localidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
