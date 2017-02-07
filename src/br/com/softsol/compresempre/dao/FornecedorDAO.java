package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Fornecedor;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */

@Component
public class FornecedorDAO {

	private final Session session;

	public FornecedorDAO(Session session) {
		this.session = session;
	}

	public List<Fornecedor> listaTudo() {
		return this.session.createCriteria(Fornecedor.class).list();
	}

	public void salva(Fornecedor fornecedor) {
		Transaction tx = session.beginTransaction();
		session.save(fornecedor);
		tx.commit();
	}

	public Fornecedor carrega(Long id) {
		return (Fornecedor) this.session.load(Fornecedor.class, id);
	}

	public void atualiza(Fornecedor fornecedor) {
		Transaction tx = session.beginTransaction();
		this.session.update(fornecedor);
		tx.commit();
	}

	public void remove(Fornecedor fornecedor) {
		Transaction tx = session.beginTransaction();
		this.session.delete(fornecedor);
		tx.commit();
	}

	public List<Fornecedor> busca(String deno_vin) {
		return session.createCriteria(Fornecedor.class)
				.add(Restrictions.ilike("deno_vin", deno_vin, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Fornecedor fornecedor) {
		session.refresh(fornecedor);
	}
}
