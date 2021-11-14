package org.serratec.backend.trabalho.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "endereco")
@Entity
public class Endereco {
	
	@Id
	@ApiModelProperty(value = "Id do endereço", required = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	
	@Column
	@ApiModelProperty(value = "CEP", required = true)
	private String cep;
	
	@Column
	@ApiModelProperty(value = "Logradouro")
	private String logradouro;
	
	@Column
	@ApiModelProperty(value = "Complemento")
	private String complemento;
	
	@Column
	@ApiModelProperty(value = "Bairro")
	private String bairro;
	
	@Column
	@ApiModelProperty(value = "Localidade")
	private String localidade;
	
	@Column
	@ApiModelProperty(value = "UF")
	private String uf;
	
	@Column
	@ApiModelProperty(value = "IBGE")
	private Long ibge;
	
	
	public Endereco() {
		super();
	}
	

	public Endereco(Endereco endereco) {
		super();
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.localidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
		this.ibge = endereco.getIbge();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Long getIbge() {
		return ibge;
	}

	public void setIbge(Long ibge) {
		this.ibge = ibge;
	}
	
	
	

}
