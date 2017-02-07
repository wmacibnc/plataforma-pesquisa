package br.com.softsol.compresempre.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Auditoria;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class AuditoriaDAO {

	private final Session session;

	public AuditoriaDAO(Session session) {
		this.session = session;
	}

	public void salva(Auditoria auditoria) {
		Transaction tx = session.beginTransaction();
		session.save(auditoria);
		tx.commit();
	}

}
