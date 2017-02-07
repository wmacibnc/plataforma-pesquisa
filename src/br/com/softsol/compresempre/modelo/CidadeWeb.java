package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
@SessionScoped
public class CidadeWeb {
	private Cidade logado;

	public void login(Cidade cidade) {
		this.logado = cidade;
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
