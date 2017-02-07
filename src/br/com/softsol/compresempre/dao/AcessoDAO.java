package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Acesso;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class AcessoDAO {

	private final Session session;

	public AcessoDAO(Session session) {
		this.session = session;
	}

	public void salva(Acesso acesso) {
		Transaction tx = session.beginTransaction();
		session.save(acesso);
		tx.commit();
	}

	// Lista tudo para formulário
	public List<Acesso> lista() {
		return this.session.createCriteria(Acesso.class).list();
	}

}
