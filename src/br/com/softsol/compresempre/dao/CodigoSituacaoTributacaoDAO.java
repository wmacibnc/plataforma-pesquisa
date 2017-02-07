package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.CodigoSituacaoTributacao;


/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class CodigoSituacaoTributacaoDAO {

	private final Session session;

	public CodigoSituacaoTributacaoDAO(Session session) {
		this.session = session;
	}

	public List<CodigoSituacaoTributacao> listaTudo() {
		return this.session.createCriteria(CodigoSituacaoTributacao.class).list();
	}

	public void salva(CodigoSituacaoTributacao CodigoSituacaoTributacao) {
		Transaction tx = session.beginTransaction();
		session.save(CodigoSituacaoTributacao);
		tx.commit();
	}

	public CodigoSituacaoTributacao carrega(Long id) {
		return (CodigoSituacaoTributacao) this.session.load(CodigoSituacaoTributacao.class, id);
	}

	public void atualiza(CodigoSituacaoTributacao CodigoSituacaoTributacao) {
		Transaction tx = session.beginTransaction();
		this.session.update(CodigoSituacaoTributacao);
		tx.commit();
	}

	public void remove(CodigoSituacaoTributacao CodigoSituacaoTributacao) {
		Transaction tx = session.beginTransaction();
		this.session.delete(CodigoSituacaoTributacao);
		tx.commit();
	}

	public List<CodigoSituacaoTributacao> busca(String nome) {
		return session.createCriteria(CodigoSituacaoTributacao.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(CodigoSituacaoTributacao CodigoSituacaoTributacao) {
		session.refresh(CodigoSituacaoTributacao);
	}
}
