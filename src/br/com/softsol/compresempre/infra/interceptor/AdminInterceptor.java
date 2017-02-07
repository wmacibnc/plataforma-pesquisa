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
 * Anotação - Interceptar Onde encontrar a anotação, vai ser interceptada Metodo
 * intercept vai ser executado.
 */

@Intercepts
public class AdminInterceptor implements Interceptor {

	// Variavéis

	private final AdministradorWeb administrador;
	private final Result result;

	// Construtor
	public AdminInterceptor(AdministradorWeb administrador, Result result) {
		this.administrador = administrador;
		this.result = result;

	}

	// Vai interceptar se o metodo tiver a anotação @Admin e Administrador não
	// logado
	public boolean accepts(ResourceMethod method) {
		// Se Administrador não logado && método com anotação - Intercepta
		return !administrador.isLogado()
				&& method.containsAnnotation(Admin.class);

	}

	// Metodo intercept - o que deve ser feito quando é encontrado a anotação
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// Redireciona para página de Login - Administrador
		result.redirectTo(AdministradorController.class).loginForm();

	}
}
