package org.serratec.backend.trabalho.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.serratec.backend.trabalho.domain.Cliente;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class ClienteDTO {
	
	@ApiModelProperty(value = "ID do cliente", required = true)
	@Column(name = "id_cliente", length = 50)
	private Long idCliente;
	
	@ApiModelProperty(value = "Nome do cliente", required = true)
	@Column(name = "nome_cliente", length = 50)
	private String nomeCliente;
	
	@ApiModelProperty(value = "Usuário do cliente")
	@Column(name = "usuario_cliente", length = 50)
	private String usuarioCliente;
	
	@ApiModelProperty(value = "Email do cliente")
	@Email
	@Column(name = "email_cliente", length = 50)
	private String emailCliente;
	
	@ApiModelProperty(value = "Data de nascimento do cliente", required = true)
	@Column(name = "nascimento_cliente")
	@Temporal(TemporalType.DATE)
	private Date nascimentoCliente;
	
	
	public ClienteDTO() {
		super();
	}
	public ClienteDTO(Cliente cliente) {
		super();
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		this.usuarioCliente = cliente.getUsuarioCliente();
		this.emailCliente = cliente.getEmailCliente();
		this.nascimentoCliente = cliente.getNascimentoCliente();
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
	public Date getNascimentoCliente() {
		return nascimentoCliente;
	}
	public void setNascimentoCliente(Date nascimentoCliente) {
		this.nascimentoCliente = nascimentoCliente;
	}

	
}
