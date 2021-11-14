package org.serratec.backend.trabalho.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@ApiModelProperty(value = "Id do cliente", required = true)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Nome do cliente", required = true)
	@Column(name = "nome_cliente", length = 50)
	private String nomeCliente;
	
	@Size(max = 50)
	@ApiModelProperty(value = "Usuário do cliente")
	@Column(name = "usuario_cliente", length = 50)
	private String usuarioCliente;
	
	@NotNull(message = "Preencha o email do cliente")
	@Size(max = 50)
	@ApiModelProperty(value = "Email do cliente")
	@Email
	@Column(name = "email_cliente", length = 50)
	private String emailCliente;
	
	@Size(max = 11)
	@ApiModelProperty(value = "CPF do cliente")
	@CPF
	@Column(name = "cpf_cliente", length = 11)
	private String cpfCliente;
	
	@ApiModelProperty(value = "Data de nascimento do cliente")
	@Column(name = "nascimento_cliente")
	@Temporal(TemporalType.DATE)
	private Date nascimentoCliente;
	
	@NotNull(message = "Preencha a senha")
	@Size(max = 20)
	@ApiModelProperty(value = "Senha do cliente", required = true)
	@Column(name = "senha", length = 20)
	private String senha;
	
	@Size(max = 8)
	@ApiModelProperty(value = "CEP do cliente", required = true)
	@Column(name = "cep", length = 8)
	private String cep; 

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	@ApiModelProperty(value = "Lista de pedidos")
	private List <Pedido> pedido;
	
	@OneToOne
	@ApiModelProperty(value = "Lista de endereços")
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
	
	public Cliente() {
		super();
	}
	
	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getUsuarioCliente() {
		return usuarioCliente;
	}


	public void setUsuarioCliente(String usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}


	public void setNascimentoCliente(Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Pedido> getPedido() {
		return pedido;
	}


	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
	    return "Código: " + idCliente + "\n Nome: " + nomeCliente + "\n Email: " + emailCliente + "\n";
	}

}