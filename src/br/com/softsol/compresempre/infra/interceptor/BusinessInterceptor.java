package br.com.softsol.compresempre.infra.interceptor;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.softsol.compresempre.controller.EmpresaController;
import br.com.softsol.compresempre.interfaces.Business;
import br.com.softsol.compresempre.modelo.EmpresaWeb;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
/*
 * Anotação - Interceptar Onde encontrar a anotação, vai ser interceptada Metodo
 * intercept vai ser executado.
 */

@Intercepts
public class BusinessInterceptor implements Interceptor {

	// Variavéis

	private final EmpresaWeb empresa;
	private final Result result;

	// Construtor
	public BusinessInterceptor(EmpresaWeb empresa, Result result) {
		this.empresa = empresa;
		this.result = result;

	}

	// Vai interceptar se o metodo tiver a anotação @Business
	public boolean accepts(ResourceMethod method) {

		// Se empresa não logado && método com anotação - Intercepta
		return !empresa.isLogado() && method.containsAnnotation(Business.class);

	}

	// Metodo intercept - o que deve ser feito quando é encontrado a anotação
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// Redireciona para página de Login - Empresa
		result.redirectTo(EmpresaController.class).loginForm();

	}
}
