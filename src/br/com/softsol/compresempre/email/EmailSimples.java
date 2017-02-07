package br.com.softsol.compresempre.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class EmailSimples {

	// Variaveis

	private final String host = "smtp.softsol.com.br";
	private final String login = "wesleymartins";
	private final String senha = "Wesley@19";
	// private String destinatario = "wmacibnc@gmail.com";
	private String remetente = "orcamento@compresempre.com.br";
	private String assunto = "COMPRE SEMPRE - Orcamento Qualificado!";

	// private String mensagem =
	// "Contate-nos para saber sobre o seu orçamento Online - sac@softsol.com.br";

	// Construtor
	public EmailSimples() {

	}

	public void envia(String destinatario, String mensagem) {
		HtmlEmail email = new HtmlEmail();
		// SimpleEmail email = new SimpleEmail();

		try {

			email.setHostName(host);
			email.setAuthentication(login, senha);
			email.setSmtpPort(587);
			email.addTo(destinatario);
			email.setFrom(remetente);
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.setSSL(true);
			email.setDebug(true);
			email.send();

		} catch (EmailException e) {
			System.err.print("...Erro:\n\t" + e.getMessage() + "\n\n");
			e.printStackTrace();
		}

	}

}
