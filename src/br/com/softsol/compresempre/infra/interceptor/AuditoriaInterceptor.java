package br.com.softsol.compresempre.infra.interceptor;

import javax.servlet.http.HttpServletRequest;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.softsol.compresempre.dao.AuditoriaDAO;
import br.com.softsol.compresempre.interfaces.Audit;
import br.com.softsol.compresempre.modelo.Auditoria;
import br.com.softsol.compresempre.modelo.EmpresaWeb;
import br.com.softsol.compresempre.modelo.ProdutoEmpresaEmProgresso;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Intercepts
public class AuditoriaInterceptor implements Interceptor {

	private final AuditoriaDAO dao;
	private final EmpresaWeb empresa;
	private final HttpServletRequest req;

	/*
	 * Anotação - Interceptar Onde encontrar a anotação, vai ser interceptada
	 * Metodo intercept vai ser executado.
	 */
	// Construtor

	public AuditoriaInterceptor(AuditoriaDAO dao, EmpresaWeb empresa,
			HttpServletRequest req, ProdutoEmpresaEmProgresso produtoEmpresa) {

		this.dao = dao;
		this.empresa = empresa;
		this.req = req;

	}

	public boolean accepts(ResourceMethod method) {
		return method.containsAnnotation(Audit.class);
	}

	// Metodo intercept - o que deve ser feito quando é encontrado a anotação
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// Faz a ação no banco normalmente
		stack.next(method, resourceInstance);

		// Salvar no banco as informações
		Auditoria auditoria = new Auditoria(req);

		// Adiciona Id da empresa na sessão
		auditoria.setUsuario(empresa.getId());

		// Adiciona Nome do metodo

		String metodo = req.getMethod();
		if (metodo.equals("POST")) {
			auditoria.setMetodo("SALVAR");
		}
		if (metodo.equals("PUT")) {
			auditoria.setMetodo("EDITAR");
		}
		if (metodo.equals("DELETE")) {
			auditoria.setMetodo("REMOVER");
		}

		// Pega o ID do Produto
		auditoria.setProduto(ProdutoEmpresaEmProgresso.getSprodutoEmpresa()
				.getProduto().getId());

		// Hora e data
		// Construtor da classe

		// Salva no banco o objeto
		this.dao.salva(auditoria);

	}
}
