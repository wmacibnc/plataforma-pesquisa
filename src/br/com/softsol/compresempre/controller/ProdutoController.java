package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.CodigoFiscalOperacoesPrestacoesDAO;
import br.com.softsol.compresempre.dao.CodigoSituacaoTributacaoDAO;
import br.com.softsol.compresempre.dao.ComissaoDAO;
import br.com.softsol.compresempre.dao.FornecedorDAO;
import br.com.softsol.compresempre.dao.ProdutoDAO;
import br.com.softsol.compresempre.dao.SubgrupoDAO;
import br.com.softsol.compresempre.dao.TipoProdutoDAO;
import br.com.softsol.compresempre.dao.UnidadeEstoqueDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.modelo.Produto;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class ProdutoController {
	private final ProdutoDAO dao;
	private final SubgrupoDAO dao2;
	private final CodigoFiscalOperacoesPrestacoesDAO dao3;
	private final FornecedorDAO dao4;
	private final TipoProdutoDAO dao5;
	private final CodigoSituacaoTributacaoDAO dao6;
	private final ComissaoDAO dao7;
	private final UnidadeEstoqueDAO dao8;
	private final Result result;

	public ProdutoController(ProdutoDAO dao, Result result, SubgrupoDAO dao2,
			CodigoFiscalOperacoesPrestacoesDAO dao3,FornecedorDAO dao4,TipoProdutoDAO dao5,
			CodigoSituacaoTributacaoDAO dao6, ComissaoDAO dao7, UnidadeEstoqueDAO dao8) {
		this.dao = dao;
		this.dao2 = dao2;
		this.dao3 = dao3;
		this.dao4 = dao4;
		this.dao5 = dao5;
		this.dao6 = dao6;
		this.dao7 = dao7;
		this.dao8 = dao8;
		this.result = result;
	}

	// Lista todos com imagem
	@Get("/produto")
	public List<Produto> lista() {
		result.include("subgrupoList", dao2.listaTudo());
		return dao.listaTudo();
	}

	// Lista todos com imagem para Destaque
	@Get("/produto/destaque")
	public List<Produto> destaque() {
		return dao.listaTudo();
	}

	// Lista todos sem Imagem
	@Get("/produto/adm")
	public List<Produto> listaadm() {
		result.include("subgrupoList", dao2.listaTudo());
		return dao.listaTudo();
	}

	// Lista para localizar o menor preço
	@Get("/produto2")
	public List<Produto> lista2() {
		return dao.listaTudo();
	}
	
	// Lista todos para empresa
	@Get("/produto/empresa")
	public List<Produto> empresa() {
		return dao.listaTudo();
	}
	
	// Lista todos para empresa - Softsol
		@Get("/produto/softsol/empresa")
		public List<Produto> empresasoftsol() {
			return dao.listaTudo();
		}

	// Adicionar
	@Admin
	@Post("/produto")
	public void adiciona(final Produto produto) {
		dao.salva(produto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Novo - Gera a interface para cadastro
	@Admin
	@Get("/produto/novo")
	public void formulario() {
		// Include da Lista de subgrupos
		result.include("subgrupoList", dao2.listaTudo());
		// Include da Codigo Fiscal de Operações e Prestações
		result.include("codigoFiscalOperacoesPrestacoesList", dao3.listaTudo());
		// Include da Lista de Fornecedor
		result.include("fornecedorList", dao4.listaTudo());
		// Include da Lista de Tipo de Produto
		result.include("tipoProdutoList", dao5.listaTudo());
	}

	// Edição
	@Admin
	@Get("/produto/{id}")
	public Produto edita(Long id) {
		result.include("subgrupoList", dao2.listaTudo());

		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@Admin
	@Put("/produto/{produto.id}")
	public void altera(final Produto produto) {
		dao.atualiza(produto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@Admin
	@Delete("/produto/{id}")
	public void remove(Long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca por nome 2 - Busca produtos pelo tipo de atividade escolhida
	public List<Produto> busca2(String nome) {
		result.include("nome", nome);
		return dao.buscaporatividadedaempresa(nome);
	}

	// Busca por nome 3
	public List<Produto> busca3(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}
	
	// Busca por nome 4
		public List<Produto> busca4(String nome) {
			result.include("nome", nome);
			//Include da Lista de Codigo Situação de Tributação
			result.include("codigoSituacaoTributacaoList", dao6.listaTudo());
			
			//Include da Lista de Comissão
			result.include("comissaoList", dao7.listaTudo());

			//Include da Lista de Unidades de estoque
			result.include("unidadeEstoqueList", dao8.listaTudo());
			return dao.busca(nome);
		}

	// Busca por nome - Destaque de produtos adicionar
	public List<Produto> buscadestaque(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/produto/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}
	
	// Busca Json para auto completar - produtos pelo tipo de atividade escolhida
		@Get("/produto/busca2.json")
		public void buscaJson2(String q) {
			result.use(json()).withoutRoot().from(dao.buscaporatividadedaempresa(q)).exclude("id")
					.serialize();
		}

}
