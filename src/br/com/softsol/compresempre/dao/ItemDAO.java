package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.Item;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class ItemDAO {

	private final Session session;

	public ItemDAO(Session session) {
		this.session = session;
	}

	public List<Item> listaTudo() {
		return this.session.createCriteria(Item.class).list();
	}

	// Lista itens para orçamento
	public List<Item> listaitensdorcamento(Long id) {
		return this.session.createCriteria(Item.class)
				.createCriteria("orcamento").add(Restrictions.eq("id", id))
				.list();
	}

	public void salva(Item item) {
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
	}

	public Item carrega(Long id) {
		return (Item) this.session.load(Item.class, id);
	}

	public void atualiza(Item item) {
		session.clear();
		Transaction tx = session.beginTransaction();
		this.session.update(item);
		tx.commit();
	}

	public void remove(Item item) {
		session.clear();
		Transaction tx = session.beginTransaction();
		this.session.delete(item);
		tx.commit();
	}

	public List<Item> busca(String nome) {
		return session.createCriteria(Item.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Item item) {
		session.refresh(item);
	}
}
