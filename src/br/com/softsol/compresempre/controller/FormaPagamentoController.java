package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.FormaPagamentoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.FormaPagamento;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class FormaPagamentoController {
	private final FormaPagamentoDAO dao;
	private final Result result;

	public FormaPagamentoController(FormaPagamentoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos
	@Get("/formaPagamento")
	public List<FormaPagamento> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/formaPagamento")
	public void adiciona(final FormaPagamento formaPagamento) {
		dao.salva(formaPagamento);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/formaPagamento/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/formaPagamento/{id}")
	public FormaPagamento edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/formaPagamento/{formaPagamento.id}")
	public void altera(final FormaPagamento formaPagamento) {
		dao.atualiza(formaPagamento);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/formaPagamento/{id}")
	public void remove(Long id) {
		FormaPagamento formaPagamento = dao.carrega(id);
		dao.remove(formaPagamento);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<FormaPagamento> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/formaPagamento/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
