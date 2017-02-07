package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import br.com.softsol.compresempre.dao.EmpresaDAO;
import br.com.softsol.compresempre.dao.ItemDAO;
import br.com.softsol.compresempre.dao.OrcamentoDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.interfaces.User;
import br.com.softsol.compresempre.modelo.AtividadeEmProgresso;
import br.com.softsol.compresempre.modelo.Empresa;
import br.com.softsol.compresempre.modelo.EmpresaEmProgresso;
import br.com.softsol.compresempre.modelo.Item;
import br.com.softsol.compresempre.modelo.Orcamento;
import br.com.softsol.compresempre.modelo.OrcamentoEmProgresso;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */
@Resource
public class OrcamentoController {
	private final OrcamentoDAO dao;
	private final ItemDAO dao2;
	private final EmpresaDAO dao3;
	private final Result result;
	private final AtividadeEmProgresso atividadeEmProgresso;

	public OrcamentoController(OrcamentoDAO dao, Result result,
			OrcamentoEmProgresso orcamentoEmProgresso, ItemDAO dao2,
			EmpresaDAO dao3, EmpresaEmProgresso empresaEmProgresso,
			AtividadeEmProgresso atividadeEmProgresso) {
		this.dao = dao;
		this.dao2 = dao2;
		this.dao3 = dao3;
		this.result = result;
		this.atividadeEmProgresso = atividadeEmProgresso;

	}

	// Lista todos
	@Admin
	@Get("/orcamento")
	public List<Orcamento> lista() {
		return dao.listaTudo();
	}

	// Orçamentos do usuário
	@User
	@Get("/orcamento/usuario/{id}")
	public List<Orcamento> usuario(Long id) {
		return dao.usuario(id);
	}

	// Lista Finalizar Orçamento
	@User
	@Get("/orcamento/confirmar/{id}")
	public List<Orcamento> finalizar(Long id) {

		// Include dos itens
		result.include("itemList", dao2.listaTudo());

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
		for (Orcamento orcamento : dao.finalizar(id)) {

			HtmlEmail email = new HtmlEmail();
			try {
				email.setHostName(host);
				email.setAuthentication(login, senha);
				email.setSmtpPort(587);
				email.addTo(orcamento.getUsuario().getEmail());
				email.setFrom(remetente);
				email.setSubject(assunto);

				String msg1 = "<html><title>CompreSempre - Orçamento Qualificado</title>"
						+ "<body><h1> Mais um orçamento CompreSempre Finalizado </h1>"
						+ "<h2> Orçamento Número : "
						+ orcamento.getId()
						+ " - Data: "
						+ orcamento.getData_cadastro()
						+ " - Hora: "
						+ orcamento.getHora_cadastro()
						+ " </h2>"
						+ "<p> Usuário: "
						+ orcamento.getUsuario().getNome()
						+ " - E-mail: "
						+ orcamento.getUsuario().getEmail()
						+ " </p>"
						+ " <p>Endereço: "
						+ orcamento.getUsuario().getEndereço()
						+ " - "
						+ orcamento.getUsuario().getBairro().getNome()
						+ " </p>" + "<h4> Item (s) do Orçamento</h4>";

				String msg2 = "";
				// Lista de produtos
				// Cabeçalho
				msg2 += ("<table border=\"1\">");
				msg2 += ("<tr>");

				msg2 += ("<td>");
				msg2 += ("Produto");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Menor Preço");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Quantidade");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Total");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Empresa");
				msg2 += ("</td>");
				msg2 += ("</tr>");
				// Fim do Cabeçalho
				for (Item item : dao2.listaitensdorcamento(orcamento.getId())) {

					msg2 += ("<tr>");

					msg2 += ("<td>");
					msg2 += (item.getProdutoEmpresa().getProduto().getNome());
					msg2 += ("</td>");

					msg2 += ("<td>");
					msg2 += ("R$ " + item.getPreco_unit());
					msg2 += ("</td>");

					msg2 += ("<td>");
					msg2 += (item.getQuantidade());
					msg2 += ("</td>");

					msg2 += ("<td>");

					DecimalFormat format = new DecimalFormat();
					format.setMaximumFractionDigits(2);
					format.setMinimumFractionDigits(1);

					msg2 += ("R$ " + format.format(item.getPreco_unit()
							* item.getQuantidade()));
					msg2 += ("</td>");

					msg2 += ("<td>");
					msg2 += (item.getProdutoEmpresa().getEmpresa()
							.getFantasia());
					msg2 += ("</td>");
					msg2 += ("</tr>");
					msg2 += ("<td>");
				}
				msg2 += ("</table>");

				String msg3 = "<p> Caso não esteja visualizando corretamente esta mensagem, acesse - "
						+ "<a href=\"http://www.compresempre.com.br\"> <font color=\"orange\">CompreSempre.com.br</a></p>"
						+ "</body></html>";

				email.setHtmlMsg(msg1 + msg2 + msg3);
				// cópia para as empresas
				for (Empresa empresa : dao3.listaTudo()) {
					// empresa tem que estar ativa para receber e-mails
					if (empresa.getSituacao().equals("1")) {
						// Somente para as empresas que pertecem a atividade selecionada
						if (empresa.getAtividade().getId() == (atividadeEmProgresso
								.getAtividade().getId())) {
							// Falta implementar - somente para as empresas da
							// cidade
							email.addCc(empresa.getEmail(),
									empresa.getFantasia());
						}
					}

				}
				email.addBcc("sac@compresempre.com.br");
				email.setSSL(true);
				email.setDebug(true);
				email.send();

			} catch (EmailException e) {
				System.err.print("...Erro:\n\t" + e.getMessage() + "\n\n");
				e.printStackTrace();
			}

		}
		// Retirar Orçamento da Sessão
		OrcamentoEmProgresso.setOrcamento(null);
		return dao.finalizar(id);
	}

	// Lista Finalizar Orçamento
	@User
	@Get("/orcamento/confirmarloja/{id}")
	public List<Orcamento> finalizarloja(Long id) {

		// Include dos itens
		result.include("itemList", dao2.listaTudo());

		/*
		 *  ****************************************************** **************************
		 *  * |: PRECISA RETIRAR ESSE MÉTODO DAQUI DE DENTRO :| |: SOMENTE PARA TESTE :| ****
		 *  *********************************************************************************
		 */

		// Envia E-mail
		String host = "smtp.gmail.com";
		String login = "wmacibnc";
		String senha = "Wesley@19";
		String remetente = "orcamento@compresempre.com.br";
		String assunto = "CompreSempre - Orcamento Qualificado!";
		for (Orcamento orcamento : dao.finalizar(id)) {

			HtmlEmail email = new HtmlEmail();
			try {
				email.setHostName(host);
				email.setAuthentication(login, senha);
				email.setSmtpPort(587);
				email.addTo(orcamento.getUsuario().getEmail());
				email.setFrom(remetente);
				email.setSubject(assunto);

				String msg1 = "<html><title>CompreSempre - Orçamento Qualificado</title>"
						+ "<body><h1> Mais um orçamento CompreSempre Finalizado </h1>"
						+ "<h2> Orçamento Número : "
						+ orcamento.getId()
						+ " - Data: "
						+ orcamento.getData_cadastro()
						+ " - Hora: "
						+ orcamento.getHora_cadastro()
						+ " </h2>"
						+ "<p> Usuário: "
						+ orcamento.getUsuario().getNome()
						+ " - E-mail: "
						+ orcamento.getUsuario().getEmail()
						+ " </p>"
						+ " <p>Endereço: "
						+ orcamento.getUsuario().getEndereço()
						+ ""
						+ orcamento.getUsuario().getBairro().getNome()
						+ " </p>" + "<h4> Item (s) do Orçamento</h4>";

				String msg2 = "";
				// Lista de produtos
				// Cabeçalho
				msg2 += ("<table border=\"1\">");
				msg2 += ("<tr>");

				msg2 += ("<td>");
				msg2 += ("Produto");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Menor Preço");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Quantidade");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Total");
				msg2 += ("</td>");

				msg2 += ("<td>");
				msg2 += ("Empresa");
				msg2 += ("</td>");
				msg2 += ("</tr>");
				// Fim do Cabeçalho
				for (Item item : dao2.listaitensdorcamento(orcamento.getId())) {

					msg2 += ("<tr>");

					msg2 += ("<td>");
					msg2 += (item.getProdutoEmpresa().getProduto().getNome());
					msg2 += ("</td>");

					msg2 += ("<td>");
					msg2 += ("R$ " + item.getPreco_unit());
					msg2 += ("</td>");

					msg2 += ("<td>");
					msg2 += (item.getQuantidade());
					msg2 += ("</td>");

					msg2 += ("<td>");

					DecimalFormat format = new DecimalFormat();
					format.setMaximumFractionDigits(2);
					format.setMinimumFractionDigits(1);

					msg2 += ("R$ " + format.format(item.getPreco_unit()
							* item.getQuantidade()));
					msg2 += ("</td>");

					msg2 += ("<td>");
					msg2 += (item.getProdutoEmpresa().getEmpresa()
							.getFantasia());
					msg2 += ("</td>");
					msg2 += ("</tr>");
					msg2 += ("<td>");
				}
				msg2 += ("</table>");

				String msg3 = "<p> Caso não esteja visualizando corretamente esta mensagem, acesse - "
						+ "<a href=\"http://www.compresempre.com.br\"> <font color=\"orange\">CompreSempre.com.br</a></p>"
						+ "</body></html>";

				email.setHtmlMsg(msg1 + msg2 + msg3);
				// cópia para a empresa
				for (Empresa empresa : dao3.listaTudo()) {
					if (EmpresaEmProgresso.getEmpresa2().getId() == empresa
							.getId()) {
						email.addCc(empresa.getEmail(), empresa.getFantasia());
					}
				}
				email.addBcc("sac@compresempre.com.br");
				email.setSSL(true);
				email.setDebug(true);
				email.send();

			} catch (EmailException e) {
				System.err.print("...Erro:\n\t" + e.getMessage() + "\n\n");
				e.printStackTrace();
			}

		}
		// Retirar Orçamento da Sessão
		OrcamentoEmProgresso.setOrcamento(null);
		return dao.finalizar(id);
	}

	// Lista Orçamento para Usuário
	@User
	@Get("/orcamento/vizualizar/{id}")
	public List<Orcamento> vizualizar(Long id) {
		result.include("itemList", dao2.listaitensdorcamento(id));
		return dao.finalizar(id);
	}

	// Adicionar
	@User
	@Post("/orcamento")
	public void adiciona(final Orcamento orcamento) {
		dao.salva(orcamento);
		// Adicionar o Orçamento na sessão
		OrcamentoEmProgresso.setOrcamento(orcamento);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(PaginasController.class).escolhaatividade();
	}

	// Novo - Gera a interface para cadastro
	@User
	@Get("/orcamento/novo")
	public void formulario() {
	}

	// Edita
	@Admin
	@Get("/orcamento/{id}")
	public Orcamento edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/orcamento/{orcamento.id}")
	public void altera(final Orcamento orcamento) {
		dao.atualiza(orcamento);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Envia o ID para Remoção
	@Admin
	@Delete("/orcamento/{id}")
	public void remove(Long id) {
		Orcamento orcamento = dao.carrega(id);
		dao.remove(orcamento);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por id
	@User
	public List<Orcamento> busca(String id) {
		result.include("id", id);
		return dao.busca(id);
	}

	// Busca Json para auto completar
	@Get("/orcamento/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("")
				.serialize();
	}

}
