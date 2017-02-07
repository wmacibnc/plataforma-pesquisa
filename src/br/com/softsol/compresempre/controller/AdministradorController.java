package br.com.softsol.compresempre.controller;

import java.util.List;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.softsol.compresempre.dao.AdministradorDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Administrador;
import br.com.softsol.compresempre.modelo.AdministradorWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class AdministradorController {
	private final AdministradorWeb administradorWeb;
	private final AdministradorDAO dao;
	private final Result result;
	private final Validator validator;

	public AdministradorController(AdministradorDAO dao, Result result,
			Validator validator, AdministradorWeb administradorWeb) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.administradorWeb = administradorWeb;

	}

	public void loginForm() {
	}

	@Admin
	public void novo() {
	}

	@Post("/administrador")
	@Admin
	public void adiciona(Administrador administrador) {
		if (dao.existeAdministrador(administrador)) {
			validator.add(new ValidationMessage("Administrador já existe",
					"administrador.login"));
		}
		validator.onErrorUsePageOf(AdministradorController.class).novo();
		dao.adiciona(administrador);
		result.redirectTo(AdministradorController.class).loginForm();
	}

	@Post("/administrador/login")
	public void login(Administrador administrador) {
		Administrador carregado = dao.carrega(administrador);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos",
					"administrador.login"));
		}
		validator.onErrorUsePageOf(AdministradorController.class).loginForm();
		administradorWeb.login(carregado);
		result.redirectTo(AdministracaoController.class).index();
	}

	@Path("/administrador/logout")
	public void logout() {
		administradorWeb.logout();
		result.redirectTo("/");
	}

	@Admin
	@Get("/administrador")
	public List<Administrador> lista() {
		return dao.listaTudo();
	}

	// Edição
	@Admin
	@Get("/administrador/{id}")
	public Administrador edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/administrador/{administrador.id}")
	public void altera(final Administrador administrador) {
		dao.atualiza(administrador);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}
}
