package com.attornatus.teste.exceptionHandler;

import java.time.LocalDateTime;

public class Problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String mensagen;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getMensagen() {
		return mensagen;
	}
	public void setMensagen(String mensagen) {
		this.mensagen = mensagen;
	}

}
