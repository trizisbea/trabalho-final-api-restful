package org.serratec.backend.trabalho.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class PedidoItemPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id do pedido")
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@ApiModelProperty(value = "Id do produto")
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	public PedidoItemPK() {
		super();
	}
	
	
	public PedidoItemPK(Pedido pedido, Produto produto) {
		super();
		this.pedido = pedido;
		this.produto = produto;
	}


	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
}
