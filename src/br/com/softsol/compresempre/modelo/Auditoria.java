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
public class Auditoria {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private Long usuario;
	private String metodo;
	private Long produto;
	private String hora;
	private String data;
	private String ip;

	// Construtor
	// Insere a hora e a data

	public Auditoria(HttpServletRequest request) {
		// Hora e data
		Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = sdf.format(dataAtual);
		this.setData(dataStr);

		Date horaAtual = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
		String horaStr = sdf2.format(horaAtual);
		this.setHora(horaStr);

		// setando o ip
		this.setIp(request.getHeader("X-FORWARDED-FOR"));

	}

	// Método set e get

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getProduto() {
		return produto;
	}

	public void setProduto(Long produto) {
		this.produto = produto;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
