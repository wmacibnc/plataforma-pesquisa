package br.com.softsol.compresempre.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UnidadeEstoque {

	//Váriaveis
	@Id
	@GeneratedValue
	private Long id;
	private String sigla;
	private String nome;
	private int unidadevenda;
	
	//Relacionamentos
	
	// Relacionamento com Item
		@OneToMany(mappedBy = "unidadeEstoque", targetEntity = ProdutoEmpresa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<ProdutoEmpresa> produtoEmpresa;
		
	// Getters and setters
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<ProdutoEmpresa> getProdutoEmpresa() {
			return produtoEmpresa;
		}

		public void setProdutoEmpresa(List<ProdutoEmpresa> produtoEmpresa) {
			this.produtoEmpresa = produtoEmpresa;
		}

		public int getUnidadevenda() {
			return unidadevenda;
		}

		public void setUnidadevenda(int unidadevenda) {
			this.unidadevenda = unidadevenda;
		}
	
}
