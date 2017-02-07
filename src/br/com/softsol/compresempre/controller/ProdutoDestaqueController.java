package br.com.softsol.compresempre.controller;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.ProdutoDestaqueDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.ProdutoDestaque;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class ProdutoDestaqueController {
	private final ProdutoDestaqueDAO dao;
	private final Result result;

	public ProdutoDestaqueController(ProdutoDestaqueDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administração
	@Get("/produtoDestaque/adm")
	public List<ProdutoDestaque> listaadm() {
		return dao.listaTudo();
	}

	// Adicionar
	@Post("/produtoDestaque")
	@Admin
	public void adiciona(final ProdutoDestaque produtoDestaque) {
		dao.salva(produtoDestaque);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).listaadm();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/produtoDestaque/{id}")
	public void remove(Long id) {
		ProdutoDestaque produtoDestaque = dao.carrega(id);
		dao.remove(produtoDestaque);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).listaadm();
	}

}
