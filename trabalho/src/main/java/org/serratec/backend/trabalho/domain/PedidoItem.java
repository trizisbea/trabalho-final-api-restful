package org.serratec.backend.trabalho.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pedido_item")
public class PedidoItem {
	
	@EmbeddedId
	private PedidoItemPK idPK = new PedidoItemPK(); 
	//id_pedido e id_produto
	
	@NotBlank(message = "Preencha a quantidade do item")
	@DecimalMin(value = "1")
	@ApiModelProperty(value = "Quantidade de itens", required = true)
	@Column(name = "quantidade_item")
	private int quantidadeItem;
	
	
	public PedidoItem(PedidoItemPK pk, int quantidadeItem) {
		super();
		this.quantidadeItem = quantidadeItem;
		this.idPK = new PedidoItemPK(pk.getPedido(), pk.getProduto());
	}

	public int getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public PedidoItemPK getIdPK() {
		return idPK;
	}

	public void setIdPK(PedidoItemPK idPK) {
		this.idPK = idPK;
	}

}
