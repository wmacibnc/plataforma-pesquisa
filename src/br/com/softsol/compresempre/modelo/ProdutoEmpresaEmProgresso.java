package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Component
@SessionScoped
public class ProdutoEmpresaEmProgresso {
	private static ProdutoEmpresa sprodutoEmpresa;

	public static ProdutoEmpresa getSprodutoEmpresa() {
		return sprodutoEmpresa;
	}

	public static void setSprodutoEmpresa(ProdutoEmpresa sprodutoEmpresa) {
		ProdutoEmpresaEmProgresso.sprodutoEmpresa = sprodutoEmpresa;
	}

}
