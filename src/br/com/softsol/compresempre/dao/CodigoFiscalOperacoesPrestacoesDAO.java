package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.CodigoFiscalOperacoesPrestacoes;


/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class CodigoFiscalOperacoesPrestacoesDAO {

	private final Session session;

	public CodigoFiscalOperacoesPrestacoesDAO(Session session) {
		this.session = session;
	}

	public List<CodigoFiscalOperacoesPrestacoes> listaTudo() {
		return this.session.createCriteria(CodigoFiscalOperacoesPrestacoes.class).list();
	}

	public void salva(CodigoFiscalOperacoesPrestacoes CodigoFiscalOperacoesPrestacoes) {
		Transaction tx = session.beginTransaction();
		session.save(CodigoFiscalOperacoesPrestacoes);
		tx.commit();
	}

	public CodigoFiscalOperacoesPrestacoes carrega(Long id) {
		return (CodigoFiscalOperacoesPrestacoes) this.session.load(CodigoFiscalOperacoesPrestacoes.class, id);
	}

	public void atualiza(CodigoFiscalOperacoesPrestacoes CodigoFiscalOperacoesPrestacoes) {
		Transaction tx = session.beginTransaction();
		this.session.update(CodigoFiscalOperacoesPrestacoes);
		tx.commit();
	}

	public void remove(CodigoFiscalOperacoesPrestacoes CodigoFiscalOperacoesPrestacoes) {
		Transaction tx = session.beginTransaction();
		this.session.delete(CodigoFiscalOperacoesPrestacoes);
		tx.commit();
	}

	public List<CodigoFiscalOperacoesPrestacoes> busca(String nome) {
		return session.createCriteria(CodigoFiscalOperacoesPrestacoes.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(CodigoFiscalOperacoesPrestacoes CodigoFiscalOperacoesPrestacoes) {
		session.refresh(CodigoFiscalOperacoesPrestacoes);
	}
}
