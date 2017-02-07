package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.GrupoFornecedorDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.GrupoFornecedor;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */
@Resource
public class GrupoFornecedorController {
	private final GrupoFornecedorDAO dao;
	private final Result result;

	public GrupoFornecedorController(GrupoFornecedorDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/grupoFornecedor")
	public List<GrupoFornecedor> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/grupoFornecedor")
	public void adiciona(final GrupoFornecedor grupoFornecedor) {
		dao.salva(grupoFornecedor);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/grupoFornecedor/novo")
	public void formulario() {
	}

	// Edição
	@Admin
	@Get("/grupoFornecedor/{id}")
	public GrupoFornecedor edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/grupoFornecedor/{grupoFornecedor.id}")
	public void altera(final GrupoFornecedor grupoFornecedor) {
		dao.atualiza(grupoFornecedor);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/grupoFornecedor/{id}")
	public void remove(Long id) {
		GrupoFornecedor grupoFornecedor = dao.carrega(id);
		dao.remove(grupoFornecedor);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<GrupoFornecedor> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/grupoFornecedor/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
