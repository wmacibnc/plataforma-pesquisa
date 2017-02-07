package br.com.softsol.compresempre.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.IndexController;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.softsol.compresempre.dao.BairroDAO;
import br.com.softsol.compresempre.dao.UsuarioDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.interfaces.User;
import br.com.softsol.compresempre.modelo.Usuario;
import br.com.softsol.compresempre.modelo.UsuarioWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Resource
public class UsuariosController {
	private final UsuarioWeb usuarioWeb;
	private final UsuarioDAO dao;
	private final BairroDAO dao2;
	private final Result result;
	private final Validator validator;

	public UsuariosController(UsuarioDAO dao, Result result,
			Validator validator, UsuarioWeb usuarioWeb, BairroDAO dao2) {
		this.dao = dao;
		this.dao2 = dao2;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	public void loginForm() {
	}

	public void novo() {
		// Include lista de bairros
		result.include("bairroList", dao2.listaTudo());
	}

	@Post("/usuarios")
	public void adiciona(Usuario usuario) {
		if (dao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage("Login já existe",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).novo();
		dao.adiciona(usuario);
		result.redirectTo(IndexController.class).index();
	}

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(AdministracaoController.class).usuario();
	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo("/");
	}

	@Admin
	@Get("/usuarios")
	public List<Usuario> lista() {
		return dao.listaTudo();
	}

	@User
	@Get("/usuarios2")
	public List<Usuario> lista2() {
		return dao.listaTudo();
	}

	// Edição
	@User
	@Get("/usuarios/{id}")
	public Usuario edita(Long id) {
		// Include lista de bairros
		result.include("bairroList", dao2.listaTudo());
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@User
	@Put("/usuarios/{usuario.id}")
	public void altera(final Usuario usuario) {
		dao.atualiza(usuario);
		// Redireciona para a paǵina
		result.redirectTo(this).lista2();
	}

}
