package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.DescontoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.interfaces.Business;
import br.com.softsol.compresempre.modelo.Desconto;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class DescontoController {
	private final DescontoDAO dao;
	private final Result result;

	public DescontoController(DescontoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/desconto")
	public List<Desconto> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Business
	@Post("/desconto")
	public void adiciona(final Desconto desconto) {
		dao.salva(desconto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Business
	@Get("/desconto/novo")
	public void formulario() {
	}

	// Edição
	@Business
	@Get("/desconto/{id}")
	public Desconto edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Business
	@Put("/desconto/{desconto.id}")
	public void altera(final Desconto desconto) {
		dao.atualiza(desconto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Business
	@Delete("/desconto/{id}")
	public void remove(Long id) {
		Desconto desconto = dao.carrega(id);
		dao.remove(desconto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Desconto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/desconto/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
