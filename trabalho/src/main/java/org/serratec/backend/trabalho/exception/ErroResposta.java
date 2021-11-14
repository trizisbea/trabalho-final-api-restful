package org.serratec.backend.trabalho.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
	
	private Integer status; 
	private String titulo; 
	private LocalDateTime dataHota;
	private List<String> erros;  //lista padrão de erros do Spring 
	
	public ErroResposta(Integer status, String titulo, LocalDateTime dataHota, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHota = dataHota;
		this.erros = erros;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataHota() {
		return dataHota;
	}

	public void setDataHota(LocalDateTime dataHota) {
		this.dataHota = dataHota;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	

}
