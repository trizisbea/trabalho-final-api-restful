package org.serratec.backend.trabalho.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.domain.Pedido;
import org.serratec.backend.trabalho.domain.PedidoItem;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component
public class PedidoDTO {
	
	@ApiModelProperty(value = "Id pedido", required = true)
	private Long idPedido;
	
	@ApiModelProperty(value = "Data do pedido", required = true)
	private Date dataPedido;
	
	@ApiModelProperty(value = "Status do pedido", required = true)
	private Boolean statusFinalizado;
	 
	private Cliente cliente;
	
	private List<PedidoItem> pedidoItens = new ArrayList<>();
	
	
	public PedidoDTO() {
		super();
	}


	public PedidoDTO(Pedido pedido) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.dataPedido = pedido.getDataPedido();
		this.statusFinalizado = pedido.getStatusFinalizado();
		this.cliente = pedido.getCliente();
		this.pedidoItens=pedido.getPedidoItem();
	}


	public Long getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}


	public Date getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}


	public Boolean getStatusFinalizado() {
		return statusFinalizado;
	}


	public void setStatusFinalizado(Boolean statusFinalizado) {
		this.statusFinalizado = statusFinalizado;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<PedidoItem> getPedidoItens() {
		return pedidoItens;
	}


	public void setPedidoItens(List<PedidoItem> pedidoItens) {
		this.pedidoItens = pedidoItens;
	}
	
	
		
	
	

}
