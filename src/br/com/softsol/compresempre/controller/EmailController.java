package br.com.softsol.compresempre.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.email.EmailSimples;
import br.com.softsol.compresempre.modelo.OrcamentoEmProgresso;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class EmailController {
	private final Result result;

	public EmailController(Result result,
			OrcamentoEmProgresso orcamentoEmProgresso) {
		this.result = result;
	}

	@Path("/email")
	public void upload(EmailSimples email) {
		String destinatario = "wmacibnc@gmail.com";
		String mensagem = "<html>Orçamento CompreSempre</html>";
		email.envia(destinatario, mensagem);
		result.redirectTo("/");
	}
}
