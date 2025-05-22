package br.com.cotiinformatica.dto;

import java.util.Date;
import java.util.UUID;

public class TarefaResponse {
	private UUID id;
	private String titulo;
	private Date data_hora;
	private boolean finalizado;
	private String categoria_nome;
	
	public TarefaResponse() {
		super();
	}

	public TarefaResponse(UUID id, String titulo, Date dataHora, boolean finalizado, String categoria) {
	  super();
		this.id = id;
		this.titulo = titulo;
		this.data_hora = dataHora;
		this.finalizado = finalizado;
		this.categoria_nome = categoria;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date dataHora) {
		this.data_hora = dataHora;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getCategoria_nome() {
		return categoria_nome;
	}

	public void setCategoria_nome(String categoria) {
		this.categoria_nome = categoria;
	}
	
	
}
