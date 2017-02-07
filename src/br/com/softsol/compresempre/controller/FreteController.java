package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.FreteDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Frete;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class FreteController {
	private final FreteDAO dao;
	private final Result result;

	public FreteController(FreteDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos
	@Get("/frete")
	public List<Frete> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/frete")
	public void adiciona(final Frete frete) {
		dao.salva(frete);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/frete/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/frete/{id}")
	public Frete edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/frete/{frete.id}")
	public void altera(final Frete frete) {
		dao.atualiza(frete);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/frete/{id}")
	public void remove(Long id) {
		Frete frete = dao.carrega(id);
		dao.remove(frete);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Frete> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/frete/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
