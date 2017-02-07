package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.AtividadeEmProgresso;
import br.com.softsol.compresempre.modelo.Produto;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class ProdutoDAO {
	private final Session session;

	public ProdutoDAO(Session session, AtividadeEmProgresso atividadeEmProgresso) {
		this.session = session;

	}

	public List<Produto> listaTudo() {
		return this.session.createCriteria(Produto.class).list();
	}
	
	//busca de produtos por atividade da empresa
	public List<Produto> buscaporatividadedaempresa(String nome){
		return this.session.createSQLQuery
				("select p.* from Produto p, ProdutoEmpresa pe " 
						+ " where p.id = pe.cod_produto and nome like '%" 
						+ nome 
						+"%' and pe.cod_empresa in " +
						" (select id from Empresa where cod_atividade ='" +
						+ AtividadeEmProgresso.getAtividade2().getId()+"')")
						.addEntity(Produto.class)
						.list();
		
	}

	public void salva(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}

	public Produto carrega(Long id) {
		return (Produto) this.session.load(Produto.class, id);
	}

	public void atualiza(Produto produto) {
		session.clear();
		Transaction tx = session.beginTransaction();
		this.session.update(produto);
		tx.commit();
	}

	public void remove(Produto produto) {
		Transaction tx = session.beginTransaction();
		this.session.delete(produto);
		tx.commit();
	}

	public List<Produto> busca(String nome) {
		return session.createCriteria(Produto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Produto produto) {
		session.refresh(produto);
	}
}
