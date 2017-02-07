package br.com.softsol.compresempre.infra.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.softsol.compresempre.controller.UsuariosController;
import br.com.softsol.compresempre.interfaces.User;
import br.com.softsol.compresempre.modelo.UsuarioWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
/*
 * Anotação - Interceptar Onde encontrar a anotação, vai ser interceptada Metodo
 * intercept vai ser executado.
 */

@Intercepts
public class UserInterceptor implements Interceptor {

	// Variavéis

	private final UsuarioWeb usuario;
	private final Result result;

	// Construtor
	public UserInterceptor(UsuarioWeb usuario, Result result) {
		this.usuario = usuario;
		this.result = result;

	}

	// Verifica se vai interceptar o método
	public boolean accepts(ResourceMethod method) {

		// Se usuário não logado && método com anotação - Intercepta
		return !usuario.isLogado() && method.containsAnnotation(User.class);

	}

	// Metodo intercept - o que deve ser feito quando é encontrado a anotação
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// Redireciona para página de Login - Usuário
		result.redirectTo(UsuariosController.class).loginForm();

	}
}