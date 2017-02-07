package br.com.softsol.compresempre.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.BairroDAO;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class MenorPrecoController {

	private BairroDAO dao;
	private Result result;

	// Construtor
	public MenorPrecoController(BairroDAO dao, Result result) {
		this.dao = dao;
		this.result = result;

	}

	// Liberado
	@Path("/menorPreco")
	public void menorpreco() {
		// Include lista de Bairro
		result.include("bairroList", dao.listaTudo());
	}
}
