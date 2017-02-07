package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.GrupoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Grupo;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class GrupoController {

	private final GrupoDAO dao;
	private final Result result;

	public GrupoController(GrupoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos
	@Get("/grupo")
	public List<Grupo> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/grupo")
	public void adiciona(Grupo grupo) {
		// Salva no banco
		dao.salva(grupo);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/grupo/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/grupo/{id}")
	public Grupo edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/Grupo/{grupo.id}")
	public void altera(final Grupo grupo) {
		dao.atualiza(grupo);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/grupo/{id}")
	public void remove(Long id) {
		Grupo grupo = dao.carrega(id);
		dao.remove(grupo);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Grupo> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/grupo/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
