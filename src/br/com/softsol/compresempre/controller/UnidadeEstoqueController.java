package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.UnidadeEstoqueDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.UnidadeEstoque;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class UnidadeEstoqueController {
	private final UnidadeEstoqueDAO dao;
	private final Result result;

	public UnidadeEstoqueController(UnidadeEstoqueDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/unidadeEstoque")
	public List<UnidadeEstoque> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/unidadeEstoque")
	public void adiciona(final UnidadeEstoque unidadeEstoque) {
		dao.salva(unidadeEstoque);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/unidadeEstoque/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/unidadeEstoque/{id}")
	public UnidadeEstoque edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/unidadeEstoque/{unidadeEstoque.id}")
	public void altera(final UnidadeEstoque unidadeEstoque) {
		dao.atualiza(unidadeEstoque);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/unidadeEstoque/{id}")
	public void remove(Long id) {
		UnidadeEstoque unidadeEstoque = dao.carrega(id);
		dao.remove(unidadeEstoque);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<UnidadeEstoque> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/unidadeEstoque/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
