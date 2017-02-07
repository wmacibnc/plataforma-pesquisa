package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Component
@SessionScoped
public class AtividadeEmProgresso {
	private static Atividade satividade;

	public static Atividade getAtividade2() {
		return satividade;
	}

	public Atividade getAtividade() {
		return satividade;
	}

	public static void setAtividade(Atividade atividade) {
		satividade = atividade;
	}
}