package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.BairroDAO;
import br.com.softsol.compresempre.dao.FornecedorDAO;
import br.com.softsol.compresempre.dao.GrupoFornecedorDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Fornecedor;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class FornecedorController {
	private final FornecedorDAO dao;
	private final Result result;
	private final BairroDAO dao2;
	private final GrupoFornecedorDAO dao3;

	public FornecedorController(FornecedorDAO dao, Result result, BairroDAO dao2, GrupoFornecedorDAO dao3) {
		this.dao = dao;
		this.dao2 = dao2;
		this.dao3 = dao3;
		this.result = result;
	}

	// Lista todos - Administrador
	@Admin
	@Get("/fornecedor")
	public List<Fornecedor> lista() {
		return dao.listaTudo();
	}
	
	// Adicionar
	@Admin
	@Post("/fornecedor")
	public void adiciona(final Fornecedor fornecedor) {
		dao.salva(fornecedor);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/fornecedor/novo")
	public void formulario() {
		//include Bairro
		result.include("bairroList",dao2.listaTudo());
		//include Grupo Fornecedor
		result.include("grupoFornecedorList",dao3.listaTudo());
	}

	// Edição
	@Admin
	@Get("/fornecedor/{id}")
	public Fornecedor edita(Long id) {
		//include Bairro
		result.include("bairroList",dao2.listaTudo());
		//include Grupo Fornecedor
		result.include("grupoFornecedorList",dao3.listaTudo());
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	@Admin
	@Put("/fornecedor/{fornecedor.id}")
	public void altera(final Fornecedor fornecedor) {
		dao.atualiza(fornecedor);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/fornecedor/{id}")
	public void remove(Long id) {
		Fornecedor fornecedor = dao.carrega(id);
		dao.remove(fornecedor);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Fornecedor> busca(String deno_vin) {
		result.include("deno_vin", deno_vin);
		return dao.busca(deno_vin);
	}

	// Busca Json para auto completar
	@Get("/fornecedor/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
