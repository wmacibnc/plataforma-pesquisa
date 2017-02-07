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
import br.com.softsol.compresempre.dao.SubgrupoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Subgrupo;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class SubgrupoController {

	private final SubgrupoDAO dao;
	private final GrupoDAO dao2;
	private final Result result;

	public SubgrupoController(SubgrupoDAO dao, Result result, GrupoDAO dao2) {
		this.dao = dao;
		this.dao2 = dao2;
		this.result = result;
	}

	// Lista todos
	@Get("/subgrupo")
	public List<Subgrupo> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/subgrupo")
	public void adiciona(Subgrupo subgrupo) {
		dao.salva(subgrupo);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/subgrupo/novo")
	public void formulario(Subgrupo subgrupo) {
		// Include lista de Grupos
		result.include("grupoList", dao2.listaTudo());
	}

	// Edição
	@Admin
	@Get("/subgrupo/{id}")
	public Subgrupo edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/subgrupo/{subgrupo.id}")
	public void altera(final Subgrupo subgrupo) {
		dao.atualiza(subgrupo);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/subgrupo/{id}")
	public void remove(Long id) {
		Subgrupo subgrupo = dao.carrega(id);
		dao.remove(subgrupo);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Subgrupo> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/subgrupo/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
