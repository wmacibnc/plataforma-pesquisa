package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Atividade;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class AtividadeDAO {

	private final Session session;

	public AtividadeDAO(Session session) {
		this.session = session;
	}

	public List<Atividade> listaTudo() {
		return this.session.createCriteria(Atividade.class).list();
	}

	public void salva(Atividade atividade) {
		Transaction tx = session.beginTransaction();
		session.save(atividade);
		tx.commit();
	}

	public Atividade carrega(Long id) {
		return (Atividade) this.session.load(Atividade.class, id);
	}

	public void atualiza(Atividade atividade) {
		Transaction tx = session.beginTransaction();
		this.session.update(atividade);
		tx.commit();
	}

	public void remove(Atividade atividade) {
		Transaction tx = session.beginTransaction();
		this.session.delete(atividade);
		tx.commit();
	}

	public List<Atividade> busca(String nome) {
		return session.createCriteria(Atividade.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Atividade atividade) {
		session.refresh(atividade);
	}
}
