package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.AtividadeDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Atividade;
import br.com.softsol.compresempre.modelo.AtividadeEmProgresso;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class AtividadeController {
	private final AtividadeDAO dao;
	private final Result result;

	public AtividadeController(AtividadeDAO dao, Result result,
			AtividadeEmProgresso atividadeEmProgresso) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos
	@Get("/atividade")
	public List<Atividade> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/atividade")
	public void adiciona(final Atividade atividade) {
		dao.salva(atividade);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/atividade/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/atividade/{id}")
	public Atividade edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/atividade/{atividade.id}")
	public void altera(final Atividade atividade) {
		dao.atualiza(atividade);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/atividade/{id}")
	public void remove(Long id) {
		Atividade atividade = dao.carrega(id);
		dao.remove(atividade);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Atividade> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/atividade/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

	// Atividade em Progresso
	@Get("/atividadeEmProgresso")
	public void Escolha(final Atividade atividade) {
		// Adicionar o empresa na sessão
		AtividadeEmProgresso.setAtividade(atividade);
		// Redireciona para página da empresa
		result.redirectTo(PaginasController.class).escolha();
	}

}
