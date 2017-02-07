package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.CodigoSituacaoTributacaoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.CodigoSituacaoTributacao;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */
@Resource
public class CodigoSituacaoTributacaoController {
	private final CodigoSituacaoTributacaoDAO dao;
	private final Result result;

	public CodigoSituacaoTributacaoController(CodigoSituacaoTributacaoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/codigoSituacaoTributacao")
	public List<CodigoSituacaoTributacao> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/codigoSituacaoTributacao")
	public void adiciona(final CodigoSituacaoTributacao codigoSituacaoTributacao) {
		dao.salva(codigoSituacaoTributacao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/codigoSituacaoTributacao/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/codigoSituacaoTributacao/{id}")
	public CodigoSituacaoTributacao edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/codigoSituacaoTributacao/{codigoSituacaoTributacao.id}")
	public void altera(final CodigoSituacaoTributacao codigoSituacaoTributacao) {
		dao.atualiza(codigoSituacaoTributacao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/codigoSituacaoTributacao/{id}")
	public void remove(Long id) {
		CodigoSituacaoTributacao codigoSituacaoTributacao = dao.carrega(id);
		dao.remove(codigoSituacaoTributacao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<CodigoSituacaoTributacao> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/codigoSituacaoTributacao/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
