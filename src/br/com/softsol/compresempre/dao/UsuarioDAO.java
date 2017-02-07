package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Usuario;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class UsuarioDAO {
	private final Session session;

	public UsuarioDAO(Session session) {
		this.session = session;
	}

	public boolean existeUsuario(Usuario usuario) {
		Usuario encontrado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.uniqueResult();
		return encontrado != null;
	}

	public void adiciona(Usuario usuario) {
		Transaction tx = this.session.beginTransaction();
		this.session.save(usuario);
		tx.commit();
	}

	public Usuario carrega(Usuario usuario) {
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.add(Restrictions.eq("senha", usuario.getSenha()))
				.uniqueResult();
	}

	public List<Usuario> listaTudo() {
		return this.session.createCriteria(Usuario.class).list();
	}

	public Usuario carrega(Long id) {
		return (Usuario) this.session.load(Usuario.class, id);
	}

	public void atualiza(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		this.session.update(usuario);
		tx.commit();
	}
}
