package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.RegimeTributacao;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class RegimeTributacaoDAO {

	private final Session session;

	public RegimeTributacaoDAO(Session session) {
		this.session = session;
	}

	public List<RegimeTributacao> listaTudo() {
		return this.session.createCriteria(RegimeTributacao.class).list();
	}

	public void salva(RegimeTributacao regimeTributacao) {
		Transaction tx = session.beginTransaction();
		session.save(regimeTributacao);
		tx.commit();
	}

	public RegimeTributacao carrega(Long id) {
		return (RegimeTributacao) this.session.load(RegimeTributacao.class, id);
	}

	public void atualiza(RegimeTributacao regimeTributacao) {
		Transaction tx = session.beginTransaction();
		this.session.update(regimeTributacao);
		tx.commit();
	}

	public void remove(RegimeTributacao regimeTributacao) {
		Transaction tx = session.beginTransaction();
		this.session.delete(regimeTributacao);
		tx.commit();
	}

	public List<RegimeTributacao> busca(String nome) {
		return session.createCriteria(RegimeTributacao.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(RegimeTributacao regimeTributacao) {
		session.refresh(regimeTributacao);
	}
}
