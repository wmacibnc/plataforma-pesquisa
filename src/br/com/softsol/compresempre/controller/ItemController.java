package br.com.softsol.compresempre.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.softsol.compresempre.dao.ItemDAO;
import br.com.softsol.compresempre.dao.ProdutoEmpresaDAO;
import br.com.softsol.compresempre.interfaces.User;
import br.com.softsol.compresempre.modelo.EmpresaEmProgresso;
import br.com.softsol.compresempre.modelo.Item;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Resource
public class ItemController {
	private final ItemDAO dao;
	private final ProdutoEmpresaDAO dao3;
	private final Result result;

	public ItemController(ItemDAO dao, Result result, ProdutoEmpresaDAO dao3,
			EmpresaEmProgresso empresaEmProgresso) {
		this.dao = dao;
		this.dao3 = dao3;
		this.result = result;
	}

	// Lista todos
	@Get("/item")
	public List<Item> lista() {
		return dao.listaTudo();
	}

	// Lista todos da loja
	@Get("/itemloja")
	public List<Item> listaloja() {
		result.include("produtoEmpresaList",
				dao3.listaEmpresa(EmpresaEmProgresso.getEmpresa2().getId()));
		return dao.listaTudo();
	}

	// Adicionar
	@User
	@Post("/item")
	public void adiciona(final Item item) {
		dao.salva(item);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Adicionar Item da Loja
	@User
	@Post("/itemloja")
	public void adicionaloja(final Item item) {
		dao.salva(item);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).listaloja();
	}

	// Novo - Gera a interface para cadastro
	@User
	@Get("/item/novo")
	public void formulario() {
	}

	// Edição
	@User
	@Get("/item/{id}")
	public Item edita(Long id) {
		return dao.carrega(id);
	}

	// Alteração - Gera a interface para alterar
	// Envia o ID para alterar
	@User
	@Put("/item/{item.id}")
	public void altera(final Item item) {
		dao.atualiza(item);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Remove
	// Envia o ID para Remoção
	@User
	@Delete("/item/{id}")
	public void remove(Long id) {
		Item item = dao.carrega(id);
		dao.remove(item);
		// Redireciona para a listagem, após a inserção.
		result.redirectTo(this).lista();
	}

	// Busca por nome
	public List<Item> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	// Busca Json para auto completar
	@Get("/item/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q)).exclude("id")
				.serialize();
	}

}
