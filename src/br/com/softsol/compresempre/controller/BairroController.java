package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.BairroDAO;
import br.com.softsol.compresempre.dao.CidadeDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Bairro;
import br.com.softsol.compresempre.modelo.BairroWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class BairroController {
	private final BairroDAO dao;
	private final Result result;
	private final BairroWeb bairroWeb;
	private final CidadeDAO dao2;

	public BairroController(BairroDAO dao, Result result, BairroWeb bairroWeb,
			CidadeDAO dao2) {
		this.dao = dao;
		this.result = result;
		this.bairroWeb = bairroWeb;
		this.dao2 = dao2;
	}

	// Lista todos
	@Get("/bairro")
	public List<Bairro> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/bairro")
	public void adiciona(final Bairro bairro) {
		dao.salva(bairro);
		// Adicionar o Bairro a Sessão
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/bairro/novo")
	public void formulario() {
		// Include para listar Cidades
		result.include("cidadeList", dao2.listaTudo());
	}

	// Edição
	@Admin
	@Get("/bairro/{id}")
	public Bairro edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/bairro/{bairro.id}")
	public void altera(final Bairro bairro) {
		dao.atualiza(bairro);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/bairro/{id}")
	public void remove(Long id) {
		Bairro bairro = dao.carrega(id);
		dao.remove(bairro);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Bairro> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/bairro/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

	// Sessão do Bairro
	public void loginForm() {
	}

	@Post("/bairro/login")
	public void login(Bairro bairro) {
		Bairro carregado = dao.carrega(bairro);
		if (carregado == null) {
			System.out.println("Bairro não encontrado!");
		}
		bairroWeb.login(carregado);
		result.redirectTo(MenorPrecoController.class).menorpreco();
	}

	@Path("/bairro/logout")
	public void logout() {
		bairroWeb.logout();
		result.redirectTo("/");
	}

}
