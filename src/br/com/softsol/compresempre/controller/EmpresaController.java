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
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.softsol.compresempre.dao.AtividadeDAO;
import br.com.softsol.compresempre.dao.BairroDAO;
import br.com.softsol.compresempre.dao.EmpresaDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.interfaces.Business;
import br.com.softsol.compresempre.modelo.Empresa;
import br.com.softsol.compresempre.modelo.EmpresaEmProgresso;
import br.com.softsol.compresempre.modelo.EmpresaWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class EmpresaController {
	private final EmpresaDAO dao;
	private final BairroDAO dao2;
	private final AtividadeDAO dao3;
	private final Result result;
	private final EmpresaWeb empresaWeb;
	private final Validator validator;

	public EmpresaController(EmpresaDAO dao, Result result,
			EmpresaWeb empresaWeb, Validator validator, BairroDAO dao2,
			AtividadeDAO dao3, EmpresaEmProgresso empregaEmProgresso) {
		this.dao = dao;
		this.dao2 = dao2;
		this.dao3 = dao3;
		this.result = result;
		this.empresaWeb = empresaWeb;
		this.validator = validator;
	}

	// Lista todos
	@Admin
	@Get("/empresa")
	public List<Empresa> lista() {
		return dao.listaTudo();
	}

	// Adicionar
	@Admin
	@Post("/empresa")
	public void adiciona(final Empresa empresa) {
		dao.salva(empresa);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/empresa/novo")
	public void formulario() {
		// Include lista de Bairro e Atividade
		result.include("bairroList", dao2.listaTudo());
		result.include("atividadeList", dao3.listaTudo());
	}

	// Edição
	@Admin
	@Get("/empresa/{id}")
	public Empresa edita(Long id) {
		return dao.carrega(id);
	}

	
	//Tela para edição - somente da porcentagem da loja
	@Business
	@Get("/empresa/porcentagem/{id}")
	public Empresa editaporcentagemloja(Long id){
		return dao.carrega(id);		
	}
	
	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/empresa/{empresa.id}")
	public void altera(final Empresa empresa) {
		dao.atualiza(empresa);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}
	
	@Business
	@Put("/empresa/porcentagem/edita/{empresa.id}")
	public void alteraporcentagemloja(final Empresa empresa) {
		dao.atualiza(empresa);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(AdministracaoController.class).empresa();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/empresa/{id}")
	public void remove(Long id) {
		Empresa empresa = dao.carrega(id);
		dao.remove(empresa);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Empresa> busca(String fantasia) {
		result.include("fantasia", fantasia);
		return dao.busca(fantasia);
	}

	// Busca Json para auto completar
	@Get("/empresa/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

	// Sessão da Emresa
	public void loginForm() {
	}

	@Post("/empresa/login")
	public void login(Empresa empresa) {
		Empresa carregado = dao.carrega(empresa);
		if (carregado == null) {
			validator.add(new ValidationMessage(
					"Login e/ou senha inválidos. Contate sac@softsol.com.br",
					"empresa.login"));
		}
		validator.onErrorUsePageOf(EmpresaController.class).loginForm();

		empresaWeb.login(carregado);
		result.redirectTo(AdministracaoController.class).empresa();
	}

	@Path("/empresa/logout")
	public void logout() {
		empresaWeb.logout();
		result.redirectTo("/");
	}

	// Empresa em Progresso
	@Get("/empresaEmProgresso")
	public void Escolha(final Empresa empresa) {
		// Adicionar o empresa na sessão
		EmpresaEmProgresso.setEmpresa(empresa);
		// Redireciona para página da empresa
		result.redirectTo(ProdutoEmpresaController.class).loja(empresa.getId());
	}

}
