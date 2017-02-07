package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Desconto;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class DescontoDAO {

	private final Session session;

	public DescontoDAO(Session session) {
		this.session = session;
	}

	public List<Desconto> listaTudo() {
		return this.session.createCriteria(Desconto.class).list();
	}

	public void salva(Desconto desconto) {
		Transaction tx = session.beginTransaction();
		session.save(desconto);
		tx.commit();
	}

	public Desconto carrega(Long id) {
		return (Desconto) this.session.load(Desconto.class, id);
	}

	public void atualiza(Desconto desconto) {
		Transaction tx = session.beginTransaction();
		this.session.update(desconto);
		tx.commit();
	}

	public void remove(Desconto desconto) {
		Transaction tx = session.beginTransaction();
		this.session.delete(desconto);
		tx.commit();
	}

	public List<Desconto> busca(String nome) {
		return session.createCriteria(Desconto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Desconto desconto) {
		session.refresh(desconto);
	}
}
