package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.UnidadeEstoque;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class UnidadeEstoqueDAO {

	private final Session session;

	public UnidadeEstoqueDAO(Session session) {
		this.session = session;
	}

	public List<UnidadeEstoque> listaTudo() {
		return this.session.createCriteria(UnidadeEstoque.class).list();
	}

	public void salva(UnidadeEstoque unidadeEstoque) {
		Transaction tx = session.beginTransaction();
		session.save(unidadeEstoque);
		tx.commit();
	}

	public UnidadeEstoque carrega(Long id) {
		return (UnidadeEstoque) this.session.load(UnidadeEstoque.class, id);
	}

	public void atualiza(UnidadeEstoque unidadeEstoque) {
		Transaction tx = session.beginTransaction();
		this.session.update(unidadeEstoque);
		tx.commit();
	}

	public void remove(UnidadeEstoque unidadeEstoque) {
		Transaction tx = session.beginTransaction();
		this.session.delete(unidadeEstoque);
		tx.commit();
	}

	public List<UnidadeEstoque> busca(String nome) {
		return session.createCriteria(UnidadeEstoque.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(UnidadeEstoque unidadeEstoque) {
		session.refresh(unidadeEstoque);
	}
}
