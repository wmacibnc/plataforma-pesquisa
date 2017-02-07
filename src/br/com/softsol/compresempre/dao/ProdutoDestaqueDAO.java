package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.ProdutoDestaque;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class ProdutoDestaqueDAO {
	private final Session session;

	public ProdutoDestaqueDAO(Session session) {
		this.session = session;

	}

	public List<ProdutoDestaque> listaTudo() {
		return this.session.createCriteria(ProdutoDestaque.class).list();
	}

	public void salva(ProdutoDestaque produtoDestaque) {
		Transaction tx = session.beginTransaction();
		session.save(produtoDestaque);
		tx.commit();
	}

	public ProdutoDestaque carrega(Long id) {
		return (ProdutoDestaque) this.session.load(ProdutoDestaque.class, id);
	}

	public void remove(ProdutoDestaque produtoDestaque) {
		Transaction tx = session.beginTransaction();
		this.session.delete(produtoDestaque);
		tx.commit();
	}

}
