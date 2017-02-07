package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Empresa;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class EmpresaDAO {

	private final Session session;

	public EmpresaDAO(Session session) {
		this.session = session;
	}

	public List<Empresa> listaTudo() {
		return this.session.createCriteria(Empresa.class)
				.addOrder(Order.asc("fantasia"))
				.list();
	}

	public void salva(Empresa empresa) {
		Transaction tx = session.beginTransaction();
		session.save(empresa);
		tx.commit();
	}

	public Empresa carrega(Long id) {
		return (Empresa) this.session.load(Empresa.class, id);
	}

	public void atualiza(Empresa empresa) {
		Transaction tx = session.beginTransaction();
		this.session.update(empresa);
		tx.commit();
	}

	public void remove(Empresa empresa) {
		Transaction tx = session.beginTransaction();
		this.session.delete(empresa);
		tx.commit();
	}

	public List<Empresa> busca(String fantasia) {
		return session
				.createCriteria(Empresa.class)
				.add(Restrictions.ilike("fantasia", fantasia,
						MatchMode.ANYWHERE)).list();
	}

	public void recarrega(Empresa empresa) {
		session.refresh(empresa);
	}

	// Sessão -Carregar
	public Empresa carrega(Empresa empresa) {
		return (Empresa) session.createCriteria(Empresa.class)
				.add(Restrictions.eq("login", empresa.getLogin()))
				.add(Restrictions.eq("senha", empresa.getSenha()))
				.add(Restrictions.ilike("situacao", "1")).uniqueResult();
	}

}
