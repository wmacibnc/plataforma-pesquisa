package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.EstadoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Estado;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class EstadoController {
	private final EstadoDAO dao;
	private final Result result;

	public EstadoController(EstadoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos
	@Get("/estado")
	public List<Estado> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/estado")
	public void adiciona(final Estado estado) {
		dao.salva(estado);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/estado/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/estado/{id}")
	public Estado edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/estado/{estado.id}")
	public void altera(final Estado estado) {
		dao.atualiza(estado);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/estado/{id}")
	public void remove(Long id) {
		Estado estado = dao.carrega(id);
		dao.remove(estado);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome

	public List<Estado> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/estado/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
