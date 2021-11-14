package org.serratec.backend.trabalho.dto;

public class PedidoItemRequestDTO {
	
	private Long idProduto; 
	private int quantidadeProduto;

	
	public PedidoItemRequestDTO() {
		super();
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	} 
	
	

}
