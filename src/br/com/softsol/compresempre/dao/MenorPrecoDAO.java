package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.MenorPreco;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class MenorPrecoDAO {

	private final Session session;

	public MenorPrecoDAO(Session session) {
		this.session = session;
	}

	public void salva(MenorPreco menorPreco) {
		Transaction tx = session.beginTransaction();
		session.save(menorPreco);
		tx.commit();
	}

	// Consulta personalizada
	public List<MenorPreco> lista() {

		return this.session.createCriteria(MenorPreco.class).list();

	}

	// Consulta personalizada
	public List<MenorPreco> lista2() {
		return this.session.createCriteria(MenorPreco.class).list();

	}

}
