package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Administrador;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class AdministradorDAO {
	private final Session session;

	public AdministradorDAO(Session session) {
		this.session = session;
	}

	public boolean existeAdministrador(Administrador administrador) {
		Administrador encontrado = (Administrador) session
				.createCriteria(Administrador.class)
				.add(Restrictions.eq("login", administrador.getLogin()))
				.uniqueResult();
		return encontrado != null;
	}

	public void adiciona(Administrador administrador) {
		Transaction tx = this.session.beginTransaction();
		this.session.save(administrador);
		tx.commit();
	}

	public Administrador carrega(Administrador administrador) {
		return (Administrador) session.createCriteria(Administrador.class)
				.add(Restrictions.eq("login", administrador.getLogin()))
				.add(Restrictions.eq("senha", administrador.getSenha()))
				.uniqueResult();
	}

	public List<Administrador> listaTudo() {
		return this.session.createCriteria(Administrador.class).list();
	}

	public Administrador carrega(Long id) {
		return (Administrador) this.session.load(Administrador.class, id);
	}

	public void atualiza(Administrador administrador) {
		Transaction tx = session.beginTransaction();
		this.session.update(administrador);
		tx.commit();
	}
}
