package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.TipoProdutoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.TipoProduto;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class TipoProdutoController {
	private final TipoProdutoDAO dao;
	private final Result result;

	public TipoProdutoController(TipoProdutoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/tipoProduto")
	public List<TipoProduto> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/tipoProduto")
	public void adiciona(final TipoProduto tipoProduto) {
		dao.salva(tipoProduto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/tipoProduto/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/tipoProduto/{id}")
	public TipoProduto edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/tipoProduto/{tipoProduto.id}")
	public void altera(final TipoProduto tipoProduto) {
		dao.atualiza(tipoProduto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/tipoProduto/{id}")
	public void remove(Long id) {
		TipoProduto tipoProduto = dao.carrega(id);
		dao.remove(tipoProduto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<TipoProduto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/tipoProduto/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
