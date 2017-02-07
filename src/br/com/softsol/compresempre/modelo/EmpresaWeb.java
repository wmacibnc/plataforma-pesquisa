package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Component
@SessionScoped
public class EmpresaWeb {
	private Empresa logado;

	public void login(Empresa empresa) {
		this.logado = empresa;
	}

	public String getFantasia() {
		return logado.getFantasia();
	}
	public double getporcentagemloja(){
		return logado.getPorcentagemloja();
	}

	public Long getId() {
		return logado.getId();
	}

	public Long getId2() {
		return getId();
	}

	public String getSituacao() {
		return getSituacao();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public void logout() {
		this.logado = null;
	}

}
