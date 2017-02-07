package br.com.softsol.compresempre.infra.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.softsol.compresempre.controller.AdministradorController;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.AdministradorWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

/*
 * Anota��o - Interceptar Onde encontrar a anota��o, vai ser interceptada Metodo
 * intercept vai ser executado.
 */

@Intercepts
public class AdminInterceptor implements Interceptor {

	// Variav�is

	private final AdministradorWeb administrador;
	private final Result result;

	// Construtor
	public AdminInterceptor(AdministradorWeb administrador, Result result) {
		this.administrador = administrador;
		this.result = result;

	}

	// Vai interceptar se o metodo tiver a anota��o @Admin e Administrador n�o
	// logado
	public boolean accepts(ResourceMethod method) {
		// Se Administrador n�o logado && m�todo com anota��o - Intercepta
		return !administrador.isLogado()
				&& method.containsAnnotation(Admin.class);

	}

	// Metodo intercept - o que deve ser feito quando � encontrado a anota��o
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// Redireciona para p�gina de Login - Administrador
		result.redirectTo(AdministradorController.class).loginForm();

	}
}
