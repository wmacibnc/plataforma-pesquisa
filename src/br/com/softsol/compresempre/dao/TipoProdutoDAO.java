package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.TipoProduto;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class TipoProdutoDAO {

	private final Session session;

	public TipoProdutoDAO(Session session) {
		this.session = session;
	}

	public List<TipoProduto> listaTudo() {
		return this.session.createCriteria(TipoProduto.class).list();
	}

	public void salva(TipoProduto tipoProduto) {
		Transaction tx = session.beginTransaction();
		session.save(tipoProduto);
		tx.commit();
	}

	public TipoProduto carrega(Long id) {
		return (TipoProduto) this.session.load(TipoProduto.class, id);
	}

	public void atualiza(TipoProduto tipoProduto) {
		Transaction tx = session.beginTransaction();
		this.session.update(tipoProduto);
		tx.commit();
	}

	public void remove(TipoProduto tipoProduto) {
		Transaction tx = session.beginTransaction();
		this.session.delete(tipoProduto);
		tx.commit();
	}

	public List<TipoProduto> busca(String nome) {
		return session.createCriteria(TipoProduto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(TipoProduto tipoProduto) {
		session.refresh(tipoProduto);
	}
}
