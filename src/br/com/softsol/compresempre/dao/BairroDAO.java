package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Bairro;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class BairroDAO {

	private final Session session;

	public BairroDAO(Session session) {
		this.session = session;
	}

	public List<Bairro> listaTudo() {
		return this.session.createCriteria(Bairro.class).list();
	}

	public void salva(Bairro bairro) {
		Transaction tx = session.beginTransaction();
		session.save(bairro);
		tx.commit();
	}

	public Bairro carrega(Long id) {
		return (Bairro) this.session.load(Bairro.class, id);
	}

	public void atualiza(Bairro bairro) {
		Transaction tx = session.beginTransaction();
		this.session.update(bairro);
		tx.commit();
	}

	public void remove(Bairro bairro) {
		Transaction tx = session.beginTransaction();
		this.session.delete(bairro);
		tx.commit();
	}

	public List<Bairro> busca(String nome) {
		return session.createCriteria(Bairro.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Bairro bairro) {
		session.refresh(bairro);
	}

	// Sessão -Carregar
	public Bairro carrega(Bairro bairro) {
		return (Bairro) session.createCriteria(Bairro.class)
				.add(Restrictions.eq("nome", bairro.getNome())).uniqueResult();
	}

}
