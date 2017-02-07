package br.com.softsol.compresempre.controller;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.blank.IndexController;
import br.com.softsol.compresempre.dao.AtividadeDAO;
import br.com.softsol.compresempre.dao.EmpresaDAO;
import br.com.softsol.compresempre.modelo.Contato;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class PaginasController {

	private Result result;
	private EmpresaDAO dao;
	private AtividadeDAO dao2;

	public PaginasController(Result result, EmpresaDAO dao, AtividadeDAO dao2) {
		this.dao = dao;
		this.dao2 = dao2;
		this.result = result;
	}

	// Todas liberadas
	@Get("/termosuso")
	public void termosuso() {
	}

	@Get("/sobre")
	public void sobre() {
	}

	@Get("/duvidas")
	public void duvidas() {
	}

	@Get("/trabalheconosco")
	public void trabalheconosco() {
	}

	@Get("/politica")
	public void politica() {
	}

	@Get("/filiacao")
	public void filiacao() {
	}

	@Get("/faleconosco")
	public void faleconosco() {
	}

	@Get("/login")
	public void login() {
	}

	@Get("/escolha")
	public void escolha() {
		// Inclusão da lista de empresas
		result.include("empresaList", dao.listaTudo());
	}

	@Get("/escolhaatividade")
	public void escolhaatividade() {
		// Inclusão da lista de atividades
		result.include("atividadeList", dao2.listaTudo());
	}

	@Get("/relatorio")
	public void relatorio() {
	}

	// filiação - envio de email
	@Get("/filiacao/email")
	public void email(String seunome, String seuemail) {
		/*
		 * ****************************************************************************
		 * |: PRECISA RETIRAR ESSE MÉTODO DAQUI DE DENTRO :| |: SOMENTE PARA
		 * TESTE :| *
		 * ***********************************************************
		 * *****************
		 */

		// Envia E-mail
		String host = "smtp.gmail.com";
		String login = "wmacibnc";
		String senha = "Wesley@19";
		String remetente = "sac@softsol.com.br";// quem ta enviando
		String assunto = "CompreSempre - Solicitação de Filiação"; // assunto

		HtmlEmail email = new HtmlEmail();
		try {
			email.setHostName(host);
			email.setAuthentication(login, senha);
			email.setSmtpPort(587);
			email.addTo(seuemail);// para
			email.setFrom(remetente);
			email.setSubject(assunto);

			String msg1 = "<html><title>CompreSempre - Solicitação de Filiação</title>"
					+ "<body>"
					+ "<h3> Agradecemos o seu contato!</h3>"
					+ "<p> Nome: "
					+ seunome
					+ "</p>"
					+ "<p> Seu e-mail "
					+ seuemail
					+ "</p>"
					+ "<p> Em breve estaremos entrando em contato! </p>";

			String msg2 = "<p> Caso não esteja visualizando corretamente esta mensagem, acesse - "
					+ "<a href=\"http://www.compresempre.com.br\"> CompreSempre</a></p>"
					+ "</body></html>";

			email.setHtmlMsg(msg1 + msg2);

			// cópia para softsol.com.br
			email.addCc("sac@softsol.com.br", "Softsol.com.br");

			email.setSSL(true);
			email.setDebug(true);
			email.send();
		} catch (EmailException e) {
			System.err.print("...Erro:\n\t" + e.getMessage() + "\n\n");
			e.printStackTrace();
		}

		result.redirectTo(IndexController.class).index();
	}

	// fale conosco - envio de email
	@Get("/faleconosco/email")
	public void email2(Contato contato) {
		/*
		 * ****************************************************************************
		 * |: PRECISA RETIRAR ESSE MÉTODO DAQUI DE DENTRO :| |: SOMENTE PARA
		 * TESTE :| *
		 * ***********************************************************
		 * *****************
		 */

		// Envia E-mail
		String host = "smtp.gmail.com";
		String login = "wmacibnc";
		String senha = "Wesley@19";
		String remetente = contato.getEmail();// quem ta enviando
		String assunto = contato.getAssunto(); // assunto

		HtmlEmail email = new HtmlEmail();
		try {
			email.setHostName(host);
			email.setAuthentication(login, senha);
			email.setSmtpPort(587);
			email.addTo("sac@softsol.com.br");// para softsol sac
			email.setFrom(remetente);
			email.setSubject(assunto);

			String msg1 = "<html><title>CompreSempre - Contato</title>"
					+ "<body>" + "<h3> Agradecemos o seu contato!</h3>"
					+ "<p> Nome: " + contato.getNome() + "</p>"
					+ "<p> Seu e-mail " + contato.getEmail() + "</p>"
					+ "<p> Assunto: " + contato.getAssunto() + "</p>"
					+ "<p> Mensagem: " + contato.getMensagem() + "</p>"

					+ "<p> Em breve estaremos respondendo sua mensagem! </p>";

			String msg2 = "<p> Caso não esteja visualizando corretamente esta mensagem, acesse - "
					+ "<a href=\"http://www.compresempre.com.br\"> CompreSempre</a></p>"
					+ "</body></html>";

			email.setHtmlMsg(msg1 + msg2);

			// cópia para remetente
			email.addCc(contato.getEmail(), contato.getNome());

			email.setSSL(true);
			email.setDebug(true);
			email.send();
		} catch (EmailException e) {
			System.err.print("...Erro:\n\t" + e.getMessage() + "\n\n");
			e.printStackTrace();
		}

		result.redirectTo(IndexController.class).index();
	}

}
