package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.GrupoFornecedor;

/**
 * @author Wesley Martins
 * @last update 29/01/2013
 */

@Component
public class GrupoFornecedorDAO {

	private final Session session;

	public GrupoFornecedorDAO(Session session) {
		this.session = session;
	}

	public List<GrupoFornecedor> listaTudo() {
		return this.session.createCriteria(GrupoFornecedor.class).list();
	}

	public void salva(GrupoFornecedor grupoFornecedor) {
		Transaction tx = session.beginTransaction();
		session.save(grupoFornecedor);
		tx.commit();
	}

	public GrupoFornecedor carrega(Long id) {
		return (GrupoFornecedor) this.session.load(GrupoFornecedor.class, id);
	}

	public void atualiza(GrupoFornecedor grupoFornecedor) {
		Transaction tx = session.beginTransaction();
		this.session.update(grupoFornecedor);
		tx.commit();
	}

	public void remove(GrupoFornecedor grupoFornecedor) {
		Transaction tx = session.beginTransaction();
		this.session.delete(grupoFornecedor);
		tx.commit();
	}

	public List<GrupoFornecedor> busca(String nome) {
		return session.createCriteria(GrupoFornecedor.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(GrupoFornecedor grupoFornecedor) {
		session.refresh(grupoFornecedor);
	}
}
