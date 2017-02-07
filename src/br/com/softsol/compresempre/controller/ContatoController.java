package br.com.softsol.compresempre.controller;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.caelum.vraptor.Get;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
public class ContatoController {

	@Get("/contato/filiacao/{}")
	public void filiacao() {

		/*
		 * *******************************************************
		 * |: PRECISA RETIRAR ESSE MÉTODO DAQUI DE DENTRO :| |: SOMENTE PARA
		 * TESTE :| *******************************************************
		 */

		// Envia E-mail
		String host = "smtp.gmail.com";
		String login = "wmacibnc";
		String senha = "Wesley@19";
		String remetente = "orcamento@compresempre.com.br";
		String assunto = "CompreSempre - Orcamento Qualificado!";

		HtmlEmail email = new HtmlEmail();
		try {
			email.setHostName(host);
			email.setAuthentication(login, senha);
			email.setSmtpPort(587);
			email.addTo("");
			email.setFrom(remetente);
			email.setSubject(assunto);

			String msg1 = "<html><title>CompreSempre - Orçamento Qualificado</title>"
					+ "<body><h1> Mais um orçamento CompreSempre Finalizado </h1>"
					+ "<h2> Orçamento Número : "
					+ " - Data Orçamento: "
					+ " - Hora do Orçamento: "
					+ " </h2>"
					+ "<h4> Dados do Usuário </h4>"
					+ "<p> Usuário: "
					+ "</p>"
					+ "<p> E-mail: "
					+ " </p>"
					+ "<h4> Item (s) do Orçamento</h4>";

			String msg2 = "";
			// Lista de produtos

			String msg3 = "<p> Caso não esteja visualizando corretamente esta mensagem, acesse - "
					+ "<a href=\"http://www.compresempre.com.br\"> CompreSempre</a></p>"
					+ "</body></html>";

			email.setHtmlMsg(msg1 + msg2 + msg3);
			email.setSSL(true);
			email.setDebug(true);
			email.send();

		} catch (EmailException e) {
			System.err.print("...Erro:\n\t" + e.getMessage() + "\n\n");
			e.printStackTrace();
		}
	}
}
