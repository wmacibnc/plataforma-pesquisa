package br.com.softsol.compresempre.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.interfaces.Business;
import br.com.softsol.compresempre.interfaces.User;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class AdministracaoController {
	@Admin
	@Path("/administracao")
	public void index() {
	}

	@Business
	@Get("/administracao/empresa")
	public void empresa() {
	}
	@Admin
	@Get("/administracao/softsol/empresa")
	public void softsol() {
	}

	@User
	@Get("/administracao/usuario")
	public void usuario() {
	}

}
