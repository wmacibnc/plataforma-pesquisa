package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Cidade;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class CidadeDAO {

	private final Session session;

	public CidadeDAO(Session session) {
		this.session = session;
	}

	public List<Cidade> listaTudo() {
		return this.session.createCriteria(Cidade.class).list();
	}

	// Lista cidade por Estado
	public List<Cidade> listacidade(Long id) {
		return this.session.createCriteria(Cidade.class)
				.createCriteria("estado").add(Restrictions.eq("id", id))
				.addOrder(Order.asc("nome")).list();
	}

	public void salva(Cidade cidade) {
		Transaction tx = session.beginTransaction();
		session.save(cidade);
		tx.commit();
	}

	public Cidade carrega(Long id) {
		return (Cidade) this.session.load(Cidade.class, id);
	}

	public void atualiza(Cidade cidade) {
		Transaction tx = session.beginTransaction();
		this.session.update(cidade);
		tx.commit();
	}

	public void remove(Cidade cidade) {
		Transaction tx = session.beginTransaction();
		this.session.delete(cidade);
		tx.commit();
	}

	public List<Cidade> busca(String nome) {
		return session.createCriteria(Cidade.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Cidade cidade) {
		session.refresh(cidade);
	}

	// Sessão -Carregar
	public Cidade carrega(Cidade cidade) {
		return (Cidade) session.createCriteria(Cidade.class)
				.add(Restrictions.eq("nome", cidade.getNome())).uniqueResult();
	}
}
