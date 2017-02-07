package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Frete;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class FreteDAO {

	private final Session session;

	public FreteDAO(Session session) {
		this.session = session;
	}

	public List<Frete> listaTudo() {
		return this.session.createCriteria(Frete.class).list();
	}

	public void salva(Frete frete) {
		Transaction tx = session.beginTransaction();
		session.save(frete);
		tx.commit();
	}

	public Frete carrega(Long id) {
		return (Frete) this.session.load(Frete.class, id);
	}

	public void atualiza(Frete frete) {
		Transaction tx = session.beginTransaction();
		this.session.update(frete);
		tx.commit();
	}

	public void remove(Frete frete) {
		Transaction tx = session.beginTransaction();
		this.session.delete(frete);
		tx.commit();
	}

	public List<Frete> busca(String nome) {
		return session.createCriteria(Frete.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Frete frete) {
		session.refresh(frete);
	}
}
