package br.com.softsol.compresempre.infra.includes;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.softsol.compresempre.dao.ProdutoDestaqueDAO;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Intercepts
public class IncludeProdutoDestaque implements Interceptor {

	// Este interceptor serve SOMENTE para setar as variáveis na tela.
	private final Result result;
	private final ProdutoDestaqueDAO dao;

	public IncludeProdutoDestaque(Result result, ProdutoDestaqueDAO dao) {
		this.result = result;
		this.dao = dao;
	}

	public boolean accepts(ResourceMethod method) {
		return true;// SEMPRE vai interceptar
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		result.include("produtoDestaqueList", dao.listaTudo()); // Inclui a
																// listagem na
																// view.
		stack.next(method, resourceInstance); // Fala para o interceptor seguir
												// seu curso normalmente.

	}
}
