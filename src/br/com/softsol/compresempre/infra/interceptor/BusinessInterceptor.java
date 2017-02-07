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
 * Anota��o - Interceptar Onde encontrar a anota��o, vai ser interceptada Metodo
 * intercept vai ser executado.
 */

@Intercepts
public class BusinessInterceptor implements Interceptor {

	// Variav�is

	private final EmpresaWeb empresa;
	private final Result result;

	// Construtor
	public BusinessInterceptor(EmpresaWeb empresa, Result result) {
		this.empresa = empresa;
		this.result = result;

	}

	// Vai interceptar se o metodo tiver a anota��o @Business
	public boolean accepts(ResourceMethod method) {

		// Se empresa n�o logado && m�todo com anota��o - Intercepta
		return !empresa.isLogado() && method.containsAnnotation(Business.class);

	}

	// Metodo intercept - o que deve ser feito quando � encontrado a anota��o
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// Redireciona para p�gina de Login - Empresa
		result.redirectTo(EmpresaController.class).loginForm();

	}
}
