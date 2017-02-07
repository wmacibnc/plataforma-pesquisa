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
public class Acesso {

	// Variaveis
	@Id
	@GeneratedValue
	private Long id;
	private Long cidade;
	private String data;
	private String hora;
	private String ip;

	// Construtur
	public Acesso(HttpServletRequest request) {
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

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
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
