package org.serratec.backend.trabalho.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoRequestDTO {
	
	private Long idCliente;
	private Long idPedido; 
	private List<PedidoItemRequestDTO> itensPedido = new ArrayList<>();
	
	public PedidoRequestDTO() {
		super();
	}
	
	public PedidoRequestDTO(PedidoRequestDTO pedido) {
		super();
		this.idCliente = pedido.getIdCliente();
		this.idPedido = pedido.getIdPedido();
		this.itensPedido = pedido.getItensPedido();
	}


	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public List<PedidoItemRequestDTO> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<PedidoItemRequestDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	
	
	
	

}
