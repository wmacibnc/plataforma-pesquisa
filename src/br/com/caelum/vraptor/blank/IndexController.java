package br.com.caelum.vraptor.blank;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.EstadoDAO;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Resource
public class IndexController {

	private final Result result;
	private final EstadoDAO dao;

	public IndexController(Result result, EstadoDAO dao) {
		this.result = result;
		this.dao = dao;

	}

	@Path("/")
	public void index() {
		// Include lista de Estados
		result.include("estadoList", dao.listaTudo());
		result.include("variable", "VRaptor!");
	}
}
