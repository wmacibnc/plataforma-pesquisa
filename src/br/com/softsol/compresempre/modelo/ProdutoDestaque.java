package br.com.softsol.compresempre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class ProdutoDestaque {

	// Váriaveis
	@Id
	@GeneratedValue
	private Long id;

	// Relacionamento com produto
	@ManyToOne
	@JoinColumn(name = "cod_produto")
	private Produto produto;

	// Get e set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
