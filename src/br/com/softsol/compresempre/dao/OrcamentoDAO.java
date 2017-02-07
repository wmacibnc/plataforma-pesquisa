package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Orcamento;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class OrcamentoDAO {

	private final Session session;

	public OrcamentoDAO(Session session) {
		this.session = session;
	}

	public List<Orcamento> listaTudo() {
		return this.session.createCriteria(Orcamento.class).list();
	}

	public void salva(Orcamento orcamento) {
		Transaction tx = session.beginTransaction();
		session.save(orcamento);
		tx.commit();
	}

	public Orcamento carrega(Long id) {
		return (Orcamento) this.session.load(Orcamento.class, id);
	}

	public void atualiza(Orcamento orcamento) {
		Transaction tx = session.beginTransaction();
		this.session.update(orcamento);
		tx.commit();
	}

	public void remove(Orcamento orcamento) {
		Transaction tx = session.beginTransaction();
		this.session.delete(orcamento);
		tx.commit();
	}

	public List<Orcamento> busca(String id) {
		return session.createCriteria(Orcamento.class)
				.add(Restrictions.ilike("id", id, MatchMode.ANYWHERE)).list();
	}

	// Finalizar Orçamento - Busca orçamento por id
	public List<Orcamento> finalizar(Long id) {
		return session.createCriteria(Orcamento.class)
				.add(Restrictions.eq("id", id)).list();
	}

	// Orçamento por cliente
	public List<Orcamento> usuario(Long id) {
		return session.createCriteria(Orcamento.class)
				.createCriteria("usuario").add(Restrictions.eq("id", id))
				.list();
	}

	public void recarrega(Orcamento orcamento) {
		session.refresh(orcamento);
	}
}
