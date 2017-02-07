package br.com.softsol.compresempre.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.FormaPagamento;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class FormaPagamentoDAO {
	private final Session session;

	public FormaPagamentoDAO(Session session) {
		this.session = session;
	}

	public List<FormaPagamento> listaTudo() {
		return this.session.createCriteria(FormaPagamento.class).list();
	}

	public void salva(FormaPagamento formaPagamento) {
		Transaction tx = session.beginTransaction();
		session.save(formaPagamento);
		tx.commit();
	}

	public FormaPagamento carrega(Long id) {
		return (FormaPagamento) this.session.load(FormaPagamento.class, id);
	}

	public void atualiza(FormaPagamento formaPagamento) {
		session.clear();
		Transaction tx = session.beginTransaction();
		this.session.update(formaPagamento);
		tx.commit();
	}

	public void remove(FormaPagamento formaPagamento) {
		Transaction tx = session.beginTransaction();
		this.session.delete(formaPagamento);
		tx.commit();
	}

	public List<FormaPagamento> busca(String nome) {
		return session.createCriteria(FormaPagamento.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(FormaPagamento formaPagamento) {
		session.refresh(formaPagamento);
	}

}
