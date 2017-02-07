package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.RegimeTributacaoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.RegimeTributacao;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */
@Resource
public class RegimeTributacaoController {
	private final RegimeTributacaoDAO dao;
	private final Result result;

	public RegimeTributacaoController(RegimeTributacaoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/regimeTributacao")
	public List<RegimeTributacao> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/regimeTributacao")
	public void adiciona(final RegimeTributacao regimeTributacao) {
		dao.salva(regimeTributacao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/regimeTributacao/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/regimeTributacao/{id}")
	public RegimeTributacao edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/regimeTributacao/{regimeTributacao.id}")
	public void altera(final RegimeTributacao regimeTributacao) {
		dao.atualiza(regimeTributacao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/regimeTributacao/{id}")
	public void remove(Long id) {
		RegimeTributacao regimeTributacao = dao.carrega(id);
		dao.remove(regimeTributacao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<RegimeTributacao> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/regimeTributacao/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
