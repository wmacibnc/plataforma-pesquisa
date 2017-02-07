package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.CodigoFiscalOperacoesPrestacoesDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.CodigoFiscalOperacoesPrestacoes;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class CodigoFiscalOperacoesPrestacoesController {
	private final CodigoFiscalOperacoesPrestacoesDAO dao;
	private final Result result;

	public CodigoFiscalOperacoesPrestacoesController(CodigoFiscalOperacoesPrestacoesDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/codigoFiscalOperacoesPrestacoes")
	public List<CodigoFiscalOperacoesPrestacoes> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/codigoFiscalOperacoesPrestacoes")
	public void adiciona(final CodigoFiscalOperacoesPrestacoes codigoFiscalOperacoesPrestacoes) {
		dao.salva(codigoFiscalOperacoesPrestacoes);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/codigoFiscalOperacoesPrestacoes/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/codigoFiscalOperacoesPrestacoes/{id}")
	public CodigoFiscalOperacoesPrestacoes edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/codigoFiscalOperacoesPrestacoes/{codigoFiscalOperacoesPrestacoes.id}")
	public void altera(final CodigoFiscalOperacoesPrestacoes codigoFiscalOperacoesPrestacoes) {
		dao.atualiza(codigoFiscalOperacoesPrestacoes);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/codigoFiscalOperacoesPrestacoes/{id}")
	public void remove(Long id) {
		CodigoFiscalOperacoesPrestacoes codigoFiscalOperacoesPrestacoes = dao.carrega(id);
		dao.remove(codigoFiscalOperacoesPrestacoes);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<CodigoFiscalOperacoesPrestacoes> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/codigoFiscalOperacoesPrestacoes/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
