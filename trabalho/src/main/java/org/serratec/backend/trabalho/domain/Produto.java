package org.serratec.backend.trabalho.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "produto")
@Entity
public class Produto {
	
	@Id
	@ApiModelProperty(value = "Id do produto", required = true)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@NotBlank(message = "Preencha o nome do produto")
	@Size(max = 50)
	@ApiModelProperty(value = "Nome do produto", required = true)
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Descrição do produto")
	@Column(name = "descricao_produto")
	private String descricaoProduto;
	
	@ApiModelProperty(value = "Quantidade do estoque")
	@Column(name = "estoque")
	private int estoque;

	@DecimalMin(value = "0.10", message = "O valor não pode ser menor que dez centavos")
	@ApiModelProperty(value = "Valor do produto")
	@DecimalMin(value = "0")
	@Column(name = "valor")
	private Double valor;

	@ApiModelProperty(value = "Categoria do produto")
	@ManyToOne
	@JoinColumn(name = "categoria_produto")
	private Categoria categoria; 
	
	@ApiModelProperty(value = "Nome do funcionário que inseriu o produto")
	@ManyToOne
	@JoinColumn(name = "inserido_por")
	private Funcionario funcionario;
	

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


}
