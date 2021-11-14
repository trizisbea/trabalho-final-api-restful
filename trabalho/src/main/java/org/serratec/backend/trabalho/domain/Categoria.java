package org.serratec.backend.trabalho.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@ApiModelProperty(value = "Id da categoria", required = true)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	@NotBlank(message = "Preencha o nome da categoria")
	@Size(max = 50)
	@ApiModelProperty(value = "Nome da categoria", required = true)
	@Column(name = "nome_categoria", length = 50)
	private String nomeCategoria;
	
	@Size(max = 100)
	@ApiModelProperty(value = "Descrição da categoria")
	@Column(name = "descricao_categoria", length = 100)
	private String descricaoCategoria;
	
	@ApiModelProperty(value = "Lista de produtos")
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Produto> produto;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	
}
