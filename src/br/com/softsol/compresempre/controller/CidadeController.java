package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.AcessoDAO;
import br.com.softsol.compresempre.dao.CidadeDAO;
import br.com.softsol.compresempre.dao.EstadoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Acesso;
import br.com.softsol.compresempre.modelo.Cidade;
import br.com.softsol.compresempre.modelo.CidadeWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class CidadeController {
	private final CidadeDAO dao;
	private final Result result;
	private final CidadeWeb cidadeWeb;
	private final EstadoDAO dao2;
	private final AcessoDAO dao3;

	public CidadeController(CidadeDAO dao, Result result, CidadeWeb cidadeWeb,
			EstadoDAO dao2, AcessoDAO dao3) {
		this.dao = dao;
		this.dao2 = dao2;
		this.dao3 = dao3;
		this.result = result;
		this.cidadeWeb = cidadeWeb;

	}

	// Lista todos
	@Get("/cidade")
	public List<Cidade> lista() {
		return dao.listaTudo();
	}

	// Lista de Cidades por Estados
	@Get("/estado/cidade")
	public List<Cidade> estados(Long id) {
		return dao.listacidade(id);
	}

	// Adicionar
	@Admin
	@Post("/cidade")
	public void adiciona(final Cidade cidade) {
		dao.salva(cidade);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/cidade/novo")
	public void formulario() {
		// Include para listar Estados
		result.include("estadoList", dao2.listaTudo());
	}

	// Edição
	@Admin
	@Get("/cidade/{id}")
	public Cidade edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/cidade/{cidade.id}")
	public void altera(final Cidade cidade) {
		dao.atualiza(cidade);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/cidade/{id}")
	public void remove(Long id) {
		Cidade cidade = dao.carrega(id);
		dao.remove(cidade);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Cidade> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/cidade/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

	// Sessão do Cidade
	public void loginForm() {
	}

	@Post("/cidade/login")
	public void login(Cidade cidade, HttpServletRequest request) {
		Cidade carregado = dao.carrega(cidade);
		if (carregado == null) {
			System.out.println("Cidade não encontrado!");
		}
		cidadeWeb.login(carregado);

		// Cadastra Acesso no sistema
		Acesso acesso = new Acesso(request);
		acesso.setCidade(cidadeWeb.getId());

		// Salva no banco
		dao3.salva(acesso);

		result.redirectTo(PaginasController.class).escolhaatividade();
	}

	@Path("/cidade/logout")
	public void logout() {
		cidadeWeb.logout();
		result.redirectTo("/");
	}

}
