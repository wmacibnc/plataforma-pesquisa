package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Estado;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class EstadoDAO {

	private final Session session;

	public EstadoDAO(Session session) {
		this.session = session;
	}

	public List<Estado> listaTudo() {
		return this.session.createCriteria(Estado.class)
				.addOrder(Order.asc("nome")).list();
	}

	public void salva(Estado estado) {
		Transaction tx = session.beginTransaction();
		session.save(estado);
		tx.commit();
	}

	public Estado carrega(Long id) {
		return (Estado) this.session.load(Estado.class, id);
	}

	public void atualiza(Estado estado) {
		Transaction tx = session.beginTransaction();
		this.session.update(estado);
		tx.commit();
	}

	public void remove(Estado estado) {
		Transaction tx = session.beginTransaction();
		this.session.delete(estado);
		tx.commit();
	}

	public List<Estado> busca(String nome) {
		return session.createCriteria(Estado.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Estado estado) {
		session.refresh(estado);
	}
}
