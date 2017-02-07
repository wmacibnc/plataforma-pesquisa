package br.com.softsol.compresempre.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.softsol.compresempre.dao.AcessoDAO;
import br.com.softsol.compresempre.dao.MenorPrecoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Acesso;
import br.com.softsol.compresempre.modelo.MenorPreco;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class RelatorioController {
	private final AcessoDAO dao;
	private final MenorPrecoDAO dao2;

	public RelatorioController(AcessoDAO dao, MenorPrecoDAO dao2) {
		this.dao = dao;
		this.dao2 = dao2;
	}

	@Admin
	@Path("/relatorio/acesso")
	public List<Acesso> acesso() {
		return dao.lista();
	}

	@Admin
	@Path("/relatorio/menorPreco")
	public List<MenorPreco> menorpreco() {
		return dao2.lista();
	}

	@Admin
	@Path("/relatorio/pesquisas")
	public List<MenorPreco> pesquisa() {
		return dao2.lista2();
	}

}
