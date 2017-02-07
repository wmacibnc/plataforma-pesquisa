package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Component
@SessionScoped
public class OrcamentoEmProgresso {
	private static Orcamento sorcamento;

	public static Orcamento getOrcamento2() {
		return sorcamento;
	}

	public Orcamento getOrcamento() {
		return sorcamento;
	}

	public static void setOrcamento(Orcamento orcamento) {
		sorcamento = orcamento;
	}
}