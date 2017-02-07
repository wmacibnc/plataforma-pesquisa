package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Comissao;


/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class ComissaoDAO {

	private final Session session;

	public ComissaoDAO(Session session) {
		this.session = session;
	}

	public List<Comissao> listaTudo() {
		return this.session.createCriteria(Comissao.class).list();
	}

	public void salva(Comissao Comissao) {
		Transaction tx = session.beginTransaction();
		session.save(Comissao);
		tx.commit();
	}

	public Comissao carrega(Long id) {
		return (Comissao) this.session.load(Comissao.class, id);
	}

	public void atualiza(Comissao Comissao) {
		Transaction tx = session.beginTransaction();
		this.session.update(Comissao);
		tx.commit();
	}

	public void remove(Comissao Comissao) {
		Transaction tx = session.beginTransaction();
		this.session.delete(Comissao);
		tx.commit();
	}

	public List<Comissao> busca(String nome) {
		return session.createCriteria(Comissao.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Comissao Comissao) {
		session.refresh(Comissao);
	}
}
