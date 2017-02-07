package br.com.softsol.compresempre.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.softsol.compresempre.modelo.EmpresaEmProgresso;
import br.com.softsol.compresempre.modelo.EmpresaWeb;
import br.com.softsol.compresempre.modelo.ProdutoEmpresa;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@Component
public class ProdutoEmpresaDAO {

	private final Session session;
	private final EmpresaWeb empresaWeb;

	public ProdutoEmpresaDAO(Session session,
			EmpresaEmProgresso empresaEmProgresso, EmpresaWeb empresaWeb) {
		this.session = session;
		this.empresaWeb = empresaWeb;
	}

	// Verifica se o produto já pertence aquela empresa
	public boolean existeProduto(ProdutoEmpresa produtoEmpresa) {

		ProdutoEmpresa encontrado = (ProdutoEmpresa) session
				.createSQLQuery(
						"select * from ProdutoEmpresa where"
								+ " cod_empresa = "
								+ produtoEmpresa.getEmpresa().getId()
								+ " and cod_produto= "
								+ produtoEmpresa.getProduto().getId())
				.addEntity(ProdutoEmpresa.class).uniqueResult();
		return encontrado != null;
	}

	//Lista todo
	public List<ProdutoEmpresa> listaTudo() {
		return this.session.createCriteria(ProdutoEmpresa.class).list();
	}

	//Lista produtos por empresa
	public List<ProdutoEmpresa> listaEmpresa(Long id) {
		return session.createCriteria(ProdutoEmpresa.class)
				.createCriteria("empresa").add(Restrictions.eq("id", id))
				.list();

	}

	// Atualiza preço para cima - consulta DAO
	public List<ProdutoEmpresa> atualizarprecoparacima(double porcentagem,
			Long id) {
		return session
				.createSQLQuery(
						"select id, ativo,quantidade_estoque,cod_empresa,codbarra,codprodutofabricante," +
						"controlaestoque,custoliquido,descontonanotafiscalporcentagem,despesasfixas,despesasvariaveis," +
						"freteporcentagem,gramatura,icmsporcentagem,impostosporcentagem,imprimilivro,ipiporcentagem," +
						"margemdelucroporcentagem,observacao,precocusto,precofaturado,precovenda,precovendaatacado," +
						"precovendaminimoepromocao,quantidadedevenda, tributacao, cod_codigoSituacaoTributacao," +
						"cod_comissao,cod_unidadeEstoque,unidadeconsumo,cod_produto,(preco+(preco*"
								+ porcentagem
								+ "/100))"
								+ "as  preco from ProdutoEmpresa where cod_empresa="
								+ id + ";").addEntity(ProdutoEmpresa.class)
				.list();
	}

	// Atualiza preço para baixo - consulta DAO
	public List<ProdutoEmpresa> atualizarprecoparabaixo(double porcentagem,
			Long id) {
		return session
				.createSQLQuery(
						"select id, ativo,quantidade_estoque,cod_empresa,codbarra,codprodutofabricante," +
						"controlaestoque,custoliquido,descontonanotafiscalporcentagem,despesasfixas,despesasvariaveis," +
						"freteporcentagem,gramatura,icmsporcentagem,impostosporcentagem,imprimilivro,ipiporcentagem," +
						"margemdelucroporcentagem,observacao,precocusto,precofaturado,precovenda,precovendaatacado," +
						"precovendaminimoepromocao,quantidadedevenda, tributacao, cod_codigoSituacaoTributacao," +
						"cod_comissao,cod_unidadeEstoque,unidadeconsumo,cod_produto,(preco-(preco*"
								+ porcentagem
								+ "/100))"
								+ "as  preco from ProdutoEmpresa where cod_empresa="
								+ id + ";").addEntity(ProdutoEmpresa.class)
				.list();
	}
	
	//Salva no banco
	public void salva(ProdutoEmpresa produtoEmpresa) {
		Transaction tx = session.beginTransaction();
		session.save(produtoEmpresa);
		tx.commit();
	}
	//Carrega para alterar
	public ProdutoEmpresa carrega(Long id) {
		return (ProdutoEmpresa) this.session.load(ProdutoEmpresa.class, id);
	}
	
	//Atualiza no banco
	public void atualiza(ProdutoEmpresa produtoEmpresa) {
		Transaction tx = session.beginTransaction();
		this.session.update(produtoEmpresa);
		tx.commit();
	}
	//Remove
	public void remove(ProdutoEmpresa produtoEmpresa) {
		Transaction tx = session.beginTransaction();
		this.session.delete(produtoEmpresa);
		tx.commit();
	}

	//Busca
	public List<ProdutoEmpresa> busca(String nome) {
		return session.createCriteria(ProdutoEmpresa.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	// caixa de busca - /produtoEmpresa/loja
	public List<ProdutoEmpresa> buscalistaEmpresa(String nome) {
		return session
				.createSQLQuery(
						"select pe.id, pe.ativo,pe.codbarra,pe.codprodutofabricante,pe.controlaestoque,pe.custoliquido,pe.descontonanotafiscalporcentagem," +
						"pe.despesasfixas,pe.despesasvariaveis,pe.freteporcentagem,pe.gramatura,pe.icmsporcentagem,pe.impostosporcentagem,pe.imprimilivro,pe.ipiporcentagem," +
						"pe.margemdelucroporcentagem,pe.observacao,pe.precocusto,pe.precofaturado,pe.precovenda,pe.precovendaatacado,pe.precovendaminimoepromocao," +
						"pe.quantidadedevenda,pe.tributacao,pe.unidadeconsumo,pe.cod_codigoSituacaoTributacao,pe.cod_comissao,pe.cod_unidadeEstoque, pe.preco+(pe.preco*(e.porcentagemloja/100)) as preco,pe.quantidade_estoque, pe.cod_empresa,pe.cod_produto, p.nome "
								+ "from Empresa e, ProdutoEmpresa pe inner join Produto p on cod_produto=p.id where nome like '%"
								+ nome
								+ "%'"
								+ "and pe.cod_empresa= "
								+ EmpresaEmProgresso.getEmpresa2().getId()+" group by id")
				.addEntity(ProdutoEmpresa.class).list();

	}	
	// caixa de busca - /produtoEmpresa/empresa
	public List<ProdutoEmpresa> buscaprodutoporEmpresa(String nome) {

		return session
				.createSQLQuery(

						"select pe.*, p.nome "
								+ "from Empresa e, ProdutoEmpresa pe inner join Produto p on cod_produto=p.id where nome like '%"
								+ nome
								+ "%'"
								+ "and pe.cod_empresa= "
								+ empresaWeb.getId2() + " group by id")
				.addEntity(ProdutoEmpresa.class).list();

	}

	public void recarrega(ProdutoEmpresa produtoEmpresa) {
		session.refresh(produtoEmpresa);
	}

	// Consulta para Localizar a empresa que tem o menor preço
	// no bairro - Corrigido - OK!
	public List<ProdutoEmpresa> buscamenorpreco(Long id, Long cod) {
		return session
				.createSQLQuery(					
						"select pe.id, pe.ativo,pe.codbarra,pe.codprodutofabricante," +
						"pe.controlaestoque,pe.custoliquido,pe.descontonanotafiscalporcentagem,pe.despesasfixas,pe.despesasvariaveis," +
						"pe.freteporcentagem,pe.gramatura,pe.icmsporcentagem,pe.impostosporcentagem,pe.imprimilivro,pe.ipiporcentagem," +
						"pe.margemdelucroporcentagem,pe.observacao,pe.precocusto,pe.precofaturado,pe.precovenda,pe.precovendaatacado," +
						"pe.precovendaminimoepromocao,pe.quantidadedevenda,pe.tributacao,pe.unidadeconsumo,pe.cod_codigoSituacaoTributacao," +
						"pe.cod_comissao,pe.cod_unidadeEstoque,(pe.preco+(pe.preco*(e.porcentagemloja/100))) as preco,pe.quantidade_estoque,"
								+ " pe.cod_empresa,pe.cod_produto from ProdutoEmpresa pe "
								+ " LEFT JOIN Empresa e ON pe.cod_empresa=e.id"
								+ " where pe.ativo='1' and e.situacao='1' and pe.cod_produto= "
								+ id + " and e.cod_bairro= " + cod
								+ " order by pe.preco asc" + " limit 1")
				.addEntity(ProdutoEmpresa.class).list();
	}

	// Consulta para Localizar a empresa que tem o menor preço
	// na Cidade - Corrigido -ok
	public List<ProdutoEmpresa> buscamenorpreco2(Long id, Long cod) {
		return session
				.createSQLQuery(
						"select pe.id, pe.ativo,pe.codbarra,pe.codprodutofabricante," +
								"pe.controlaestoque,pe.custoliquido,pe.descontonanotafiscalporcentagem,pe.despesasfixas,pe.despesasvariaveis," +
								"pe.freteporcentagem,pe.gramatura,pe.icmsporcentagem,pe.impostosporcentagem,pe.imprimilivro,pe.ipiporcentagem," +
								"pe.margemdelucroporcentagem,pe.observacao,pe.precocusto,pe.precofaturado,pe.precovenda,pe.precovendaatacado," +
								"pe.precovendaminimoepromocao,pe.quantidadedevenda,pe.tributacao,pe.unidadeconsumo,pe.cod_codigoSituacaoTributacao," +
								"pe.cod_comissao,pe.cod_unidadeEstoque,(pe.preco+(pe.preco*(e.porcentagemloja/100))) as preco,pe.quantidade_estoque,"
								+ " pe.cod_empresa, pe.cod_produto from ProdutoEmpresa pe"
								+ " LEFT JOIN Empresa e ON pe.cod_empresa=e.id where pe.ativo='1' and e.situacao='1'"
								+ " and pe.cod_produto="
								+ id
								+ " and e.cod_bairro in (select b.id from Bairro b where cod_cidade= "
								+ cod + ")" + " order by pe.preco asc limit 1;")
				.addEntity(ProdutoEmpresa.class).list();

	}
}