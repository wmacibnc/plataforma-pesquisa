package br.com.softsol.compresempre.infra.includes;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.softsol.compresempre.dao.GrupoDAO;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Intercepts
public class IncludeGrupo implements Interceptor {

	// Este interceptor serve SOMENTE para setar as variáveis na tela.
	private final Result result;
	private final GrupoDAO dao;

	public IncludeGrupo(Result result, GrupoDAO dao) {
		this.result = result;
		this.dao = dao;
	}

	public boolean accepts(ResourceMethod method) {
		return true;// SEMPRE vai interceptar
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.include("grupoList", dao.listaTudo()); // Inclui a listagem na
														// view.
		stack.next(method, resourceInstance); // Fala para o interceptor seguir
												// seu curso normalmente.

	}
}
