package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.ComissaoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Comissao;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */
@Resource
public class ComissaoController {
	private final ComissaoDAO dao;
	private final Result result;

	public ComissaoController(ComissaoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/comissao")
	public List<Comissao> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/comissao")
	public void adiciona(final Comissao comissao) {
		dao.salva(comissao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/comissao/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/comissao/{id}")
	public Comissao edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/comissao/{comissao.id}")
	public void altera(final Comissao comissao) {
		dao.atualiza(comissao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/comissao/{id}")
	public void remove(Long id) {
		Comissao comissao = dao.carrega(id);
		dao.remove(comissao);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Comissao> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/comissao/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
