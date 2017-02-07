package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.softsol.compresempre.dao.CodigoSituacaoTributacaoDAO;
import br.com.softsol.compresempre.dao.ComissaoDAO;
import br.com.softsol.compresempre.dao.MenorPrecoDAO;
import br.com.softsol.compresempre.dao.ProdutoEmpresaDAO;
import br.com.softsol.compresempre.dao.UnidadeEstoqueDAO;
import br.com.softsol.compresempre.interfaces.Admin;
import br.com.softsol.compresempre.interfaces.Audit;
import br.com.softsol.compresempre.interfaces.Business;
import br.com.softsol.compresempre.modelo.EmpresaWeb;
import br.com.softsol.compresempre.modelo.MenorPreco;
import br.com.softsol.compresempre.modelo.ProdutoEmpresa;
import br.com.softsol.compresempre.modelo.ProdutoEmpresaEmProgresso;

/**
 * @author Wesley Martins
 * @last update 31/01/2013
 */
@Resource
public class ProdutoEmpresaController {
	private final ProdutoEmpresaDAO dao;
	private final Result result;
	private final MenorPrecoDAO dao2;
	private final CodigoSituacaoTributacaoDAO dao3;
	private final ComissaoDAO dao4;
	private final UnidadeEstoqueDAO dao5;
	
	private final Validator validator;

	public ProdutoEmpresaController(ProdutoEmpresaDAO dao, Result result,
			Validator validator, MenorPrecoDAO dao2, EmpresaWeb empresaWeb,
			CodigoSituacaoTributacaoDAO dao3, ComissaoDAO dao4, UnidadeEstoqueDAO dao5) {

		this.dao = dao;
		this.dao2 = dao2;
		this.dao3 = dao3;
		this.dao4 = dao4;
		this.dao5 = dao5;
		this.result = result;
		this.validator = validator;
	}

	// Lista todos
	@Admin
	@Get("/produtoEmpresa")
	public List<ProdutoEmpresa> lista() {
		return dao.listaTudo();
	}

	// Lista todos - Empresa
	@Business
	@Get("/produtoEmpresa/empresa")
	public List<ProdutoEmpresa> listaEmpresa(Long id) {
		return dao.listaEmpresa(id);
	}
	
	// Lista todos - Empresa Softsol
		@Admin
		@Get("/produtoEmpresa/softsol/empresa")
		public List<ProdutoEmpresa> listaEmpresasoftsol(Long id) {
			return dao.listaEmpresa(id);
		}

	// Lista todos - Loja Virtual da empresa
	@Get("/produtoEmpresa/loja")
	public List<ProdutoEmpresa> loja(Long id) {
		return dao.listaEmpresa(id);
	}

	// Lista todos - Loja Virtual da empresa - XML
	@Get("/produtoEmpresa/loja2")
	public void loja2(Long id) {
		// Resultado em XML
		result.use(Results.json()).from(dao.listaEmpresa(id)).recursive()
				.serialize();
	}

	// Lista todos - teste
	@Business
	@Get("/produtoEmpresa2")
	public List<ProdutoEmpresa> lista2() {
		return dao.listaTudo();
	}

	// Adicionar
	@Audit
	@Business
	@Post("/produtoEmpresa")
	public void adiciona(ProdutoEmpresa produtoEmpresa) {

		if (dao.existeProduto(produtoEmpresa)) {
			validator.add(new ValidationMessage("Produto Já existe",
					"produtoEmpresa.produto"));
			validator.onErrorUsePageOf(ProdutoController.class).empresa();
			result.redirectTo(ProdutoEmpresaController.class).lista();
		} else {
			dao.salva(produtoEmpresa);
			// Colocando o ProdutoEmpresa na Sessão
			ProdutoEmpresaEmProgresso.setSprodutoEmpresa(produtoEmpresa);
			// Redireciona para a página de administração
			result.redirectTo(AdministracaoController.class).empresa();
		}

	}
	
	// Adicionar - Softsol
		@Audit
		@Admin
		@Post("/produtoEmpresa/softsol")
		public void adicionasoftsol(ProdutoEmpresa produtoEmpresa) {

			if (dao.existeProduto(produtoEmpresa)) {
				validator.add(new ValidationMessage("Produto Já existe",
						"produtoEmpresa.produto"));
				validator.onErrorUsePageOf(ProdutoController.class).empresa();
				result.redirectTo(ProdutoEmpresaController.class).lista();
			} else {
				dao.salva(produtoEmpresa);
				// Colocando o ProdutoEmpresa na Sessão
				ProdutoEmpresaEmProgresso.setSprodutoEmpresa(produtoEmpresa);
				// Redireciona para a página de administração
				result.redirectTo(AdministracaoController.class).softsol();
			}

		}

	// Novo - Gera a interface para cadastro
	@Business
	@Get("/produtoEmpresa/novo")
	public void formulario() {
	}
	// Alteração - Gera a interface para alterar

	// Edição
	@Business
	@Get("/produtoEmpresa/{id}")
	public ProdutoEmpresa edita(Long id) {
		return dao.carrega(id);
	}
	// Alteração - Gera a interface para alterar

	// Edição - Softsol
	@Admin
	@Get("/produtoEmpresa/softsol/{id}")
	public ProdutoEmpresa editasoftsol(Long id) {
		//Include da Lista de Codigo Situação de Tributação
		result.include("codigoSituacaoTributacaoList", dao3.listaTudo());
		
		//Include da Lista de Comissão
		result.include("comissaoList", dao4.listaTudo());

		//Include da Lista de Unidades de estoque
		result.include("unidadeEstoqueList", dao5.listaTudo());
		return dao.carrega(id);
	}
	
	// Envia o ID para alterar
	@Audit
	@Business
	@Put("/produtoEmpresa/{produtoEmpresa.id}")
	public void altera(final ProdutoEmpresa produtoEmpresa) {
		dao.atualiza(produtoEmpresa);

		// Colocando o ProdutoEmpresa na Sessão
		ProdutoEmpresaEmProgresso.setSprodutoEmpresa(produtoEmpresa);
		// Redireciona para a página de administração
		result.redirectTo(AdministracaoController.class).empresa();
	}
	// Envia o ID para alterar
		@Audit
		@Business
		@Put("/produtoEmpresa/softsol/{produtoEmpresa.id}")
		public void alterasoftsol(final ProdutoEmpresa produtoEmpresa) {
			dao.atualiza(produtoEmpresa);

			// Colocando o ProdutoEmpresa na Sessão
			ProdutoEmpresaEmProgresso.setSprodutoEmpresa(produtoEmpresa);
			// Redireciona para a página de administração
			result.redirectTo(AdministracaoController.class).softsol();
		}

	// Remove
	// Envia o ID para Remoção
	@Audit
	@Business
	@Delete("/produtoEmpresa/{id}")
	public void remove(Long id) {
		ProdutoEmpresa produtoEmpresa = dao.carrega(id);
		dao.remove(produtoEmpresa);
		// Colocando o ProdutoEmpresa na Sessão
		ProdutoEmpresaEmProgresso.setSprodutoEmpresa(produtoEmpresa);

		// Redireciona para a página de administração
		result.redirectTo(AdministracaoController.class).empresa();
	}

	// Remove - Softsol
		// Envia o ID para Remoção
		@Audit
		@Admin
		@Delete("/produtoEmpresa/softsol/{id}")
		public void removesoftsol(Long id) {
			ProdutoEmpresa produtoEmpresa = dao.carrega(id);
			dao.remove(produtoEmpresa);
			// Colocando o ProdutoEmpresa na Sessão
			ProdutoEmpresaEmProgresso.setSprodutoEmpresa(produtoEmpresa);

			// Redireciona para a página de administração
			result.redirectTo(AdministracaoController.class).softsol();
		}
	// Página do menor preço bairro
	// Sendo o id do produto e cod do bairro

	@Get("/produtoEmpresa/menorpreco/bairro/{id}/{cod}")
	public List<ProdutoEmpresa> menorpreco(Long id, Long cod,
			HttpServletRequest request) {
		// Salvar dados na tabela MenorPreço Para gerar relatórios

		// Criando o objeto
		MenorPreco menorPreco = new MenorPreco(request);
		menorPreco.setTipo("Bairro");
		menorPreco.setLocalidade(cod);
		menorPreco.setProduto(id);

		for (ProdutoEmpresa produtoEmpresa : dao.buscamenorpreco(id, cod)) {
			menorPreco.setEmpresa(produtoEmpresa.getEmpresa().getId());
		}

		// Salvando no banco - para o relatório o menor preço
		dao2.salva(menorPreco);

		return dao.buscamenorpreco(id, cod);
	}

	// Página do menor preço cidade
	// Sendo o id do produto e cod da cidade
	@Get("/produtoEmpresa/menorpreco/cidade/{id}/{cod}")
	public List<ProdutoEmpresa> menorpreco2(Long id, Long cod,
			HttpServletRequest request) {

		// Criando o objeto
		MenorPreco menorPreco = new MenorPreco(request);
		menorPreco.setTipo("Cidade");
		menorPreco.setLocalidade(cod);
		menorPreco.setProduto(id);
		for (ProdutoEmpresa produtoEmpresa : dao.buscamenorpreco2(id, cod)) {
			long empresa = produtoEmpresa.getEmpresa().getId();
			menorPreco.setEmpresa(empresa);
		}

		// Salvando no banco
		dao2.salva(menorPreco);
		return dao.buscamenorpreco2(id, cod);
	}

	// Busca por nome
	public List<ProdutoEmpresa> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/produtoEmpresa/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

	// Busca por id do produto
	public List<ProdutoEmpresa> busca2(String nome) {
		result.include("nome", nome);
		return dao.buscalistaEmpresa(nome);
	}

	// Busca produto por empresa
	// Sendo o id código da empresa e nome o nome do produto
	@Get("/produtoEmpresa/buscaloja/{nome}")
	public List<ProdutoEmpresa> buscaproduto(String nome) {
		// result.include("empresaList", dao3.listaTudo());
		return dao.buscalistaEmpresa(nome);

	}

	public List<ProdutoEmpresa> busca3(String nome) {
		result.include("nome", nome);
		return dao.buscaprodutoporEmpresa(nome);
	}
	public List<ProdutoEmpresa> busca4(String nome) {
		result.include("nome", nome);
		return dao.buscaprodutoporEmpresa(nome);
	}

	// Busca Json para buscar produto por empresa
	@Get("/produtoEmpresa/busca2.json")
	public void buscaJson2(String q) {
		result.use(json()).withoutRoot().from(dao.buscalistaEmpresa(q))
				.serialize();
	}

	// Busca Json para buscar produto por empresa
	@Get("/produtoEmpresa/busca3.json")
	public void buscaJson3(String q) {
		result.use(json()).withoutRoot().from(dao.buscaprodutoporEmpresa(q))
				.serialize();
	}

	// Atualizar Preço - Aumentar em porcentagem
	@Business
	@Get("/produtoEmpresa/acrescimo/{id}")
	public List<ProdutoEmpresa> atualizaprecoparacima(double porcentagem,
			Long id) {
		return dao.atualizarprecoparacima(porcentagem, id);
	}

	// Atualizar Preço - Diminuir em porcentagem
	@Business
	@Get("/produtoEmpresa/decrescimo/{id}")
	public List<ProdutoEmpresa> atualizaprecoparabaixo(double porcentagem,
			Long id) {
		return dao.atualizarprecoparabaixo(porcentagem, id);
	}
}
