package br.com.softsol.compresempre.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */
@Entity
public class Orcamento {

	// Variáveis
	@Id
	@GeneratedValue
	private Long id;
	private String data_cadastro;
	private String hora_cadastro;

	/*
	 * Relacionamento com Frete
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="cod_frete") private Frete frete;
	 * 
	 * //Relacionamento com Desconto
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="cod_desconto") private Desconto desconto;
	 * 
	 * //Relacionamento com Forma de Pagamento
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="cod_formaPagamento") private FormaPagamento
	 * formaPagamento;
	 */

	public Orcamento() {
		// Hora e data
		Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = sdf.format(dataAtual);
		this.setData_cadastro(dataStr);

		Date horaAtual = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
		String horaStr = sdf2.format(horaAtual);
		this.setHora_cadastro(horaStr);
	}

	// Relacionamento com Item
	@OneToMany(mappedBy = "orcamento", targetEntity = Item.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> item;

	// Relacionamento com Usuário
	@ManyToOne
	@JoinColumn(name = "cod_usuario")
	private Usuario usuario;

	// Método set e get
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public Frete getFrete() { return frete; } public void setFrete(Frete
	 * frete) { this.frete = frete; } public Desconto getDesconto() { return
	 * desconto; } public void setDesconto(Desconto desconto) { this.desconto =
	 * desconto; } public FormaPagamento getFormaPagamento() { return
	 * formaPagamento; } public void setFormaPagamento(FormaPagamento
	 * formaPagamento) { this.formaPagamento = formaPagamento; }
	 */

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getHora_cadastro() {
		return hora_cadastro;
	}

	public void setHora_cadastro(String hora_cadastro) {
		this.hora_cadastro = hora_cadastro;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
