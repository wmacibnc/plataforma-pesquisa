package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Component
@SessionScoped
public class AdministradorWeb {
	private Administrador logado;

	public void login(Administrador administrador) {
		this.logado = administrador;
	}

	public String getNome() {
		return logado.getNome();
	}

	public Long getId() {
		return logado.getId();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public void logout() {
		this.logado = null;
	}
}
