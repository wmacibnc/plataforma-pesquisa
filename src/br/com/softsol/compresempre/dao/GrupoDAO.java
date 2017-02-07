package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Grupo;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class GrupoDAO {
	private final Session session;

	public GrupoDAO(Session session) {
		this.session = session;
	}

	public List<Grupo> listaTudo() {
		return this.session.createCriteria(Grupo.class)
				.addOrder(Order.asc("nome")).list();
	}

	public void salva(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		session.save(grupo);
		tx.commit();
	}

	public Grupo carrega(Long id) {
		return (Grupo) this.session.load(Grupo.class, id);
	}

	public void atualiza(Grupo grupo) {
		session.clear();
		Transaction tx = session.beginTransaction();
		this.session.update(grupo);
		tx.commit();
	}

	public void remove(Grupo grupo) {
		Transaction tx = session.beginTransaction();
		this.session.delete(grupo);
		tx.commit();
	}

	public List<Grupo> busca(String nome) {
		return session.createCriteria(Grupo.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Grupo grupo) {
		session.refresh(grupo);
	}

}
