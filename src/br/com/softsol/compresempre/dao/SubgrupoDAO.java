package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Subgrupo;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class SubgrupoDAO {
	private final Session session;

	public SubgrupoDAO(Session session) {
		this.session = session;
	}

	public List<Subgrupo> listaTudo() {
		return this.session.createCriteria(Subgrupo.class)
				.addOrder(Order.asc("nome")).list();
	}

	public void salva(Subgrupo subgrupo) {
		Transaction tx = session.beginTransaction();
		session.save(subgrupo);
		tx.commit();
	}

	public Subgrupo carrega(Long id) {
		return (Subgrupo) this.session.load(Subgrupo.class, id);
	}

	public void atualiza(Subgrupo subgrupo) {
		session.clear();
		Transaction tx = session.beginTransaction();
		this.session.update(subgrupo);
		tx.commit();
	}

	public void remove(Subgrupo subgrupo) {
		Transaction tx = session.beginTransaction();
		this.session.delete(subgrupo);
		tx.commit();
	}

	public List<Subgrupo> busca(String nome) {
		return session.createCriteria(Subgrupo.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Subgrupo subgrupo) {
		session.refresh(subgrupo);
	}

}
