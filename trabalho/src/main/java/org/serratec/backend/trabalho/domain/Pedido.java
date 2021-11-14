package org.serratec.backend.trabalho.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.serratec.backend.trabalho.dto.PedidoRequestDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "pedido")
@Entity
public class Pedido {
	
	@Id
	@ApiModelProperty(value = "Id do pedido", required = true)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@ApiModelProperty(value = "Data do pedido")
	@Column(name = "data_pedido")
	@Temporal(TemporalType.DATE)
	private Date dataPedido;
	
	@ApiModelProperty(value = "Status do pedido")
	@Column(name = "status_finalizado")
	private Boolean statusFinalizado; 
	
	@ApiModelProperty(value = "Cliente")
	@ManyToOne
	@JoinColumn(name = "cliente_pedido")
	private Cliente cliente;
	
	@ApiModelProperty(value = "Lista de pedido-item")
	@OneToMany(mappedBy = "idPK.pedido", cascade = CascadeType.PERSIST)
	private List<PedidoItem> pedidoItens = new ArrayList<>();
	
	
	public Pedido(Pedido pedido) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.pedidoItens = pedido.getPedidoItem();
		this.cliente = pedido.getCliente();
	}
	

	public Pedido() {
		super();
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

	public List<PedidoItem> getPedidoItem() {
		return pedidoItens;
	}

	public void setPedidoItem(List<PedidoItem> pedidoItem) {
		this.pedidoItens = pedidoItem;
	}


	
}
