package br.com.softsol.compresempre.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Component
@SessionScoped
public class EmpresaEmProgresso {
	private static Empresa sempresa;

	public static Empresa getEmpresa2() {
		return sempresa;
	}

	public Empresa getEmpresa() {
		return sempresa;
	}

	public static void setEmpresa(Empresa empresa) {
		sempresa = empresa;
	}
}