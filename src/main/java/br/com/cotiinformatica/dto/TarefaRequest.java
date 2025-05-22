package br.com.cotiinformatica.dto;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TarefaRequest {
	
	@NotNull
	private UUID id;

	@NotBlank
	private String titulo;

	@NotNull
	private Date data_hora;

	private boolean finalizado;
	
	@NotBlank
	private String categoria_name;
	
	public TarefaRequest() {
		super();
	}

	public TarefaRequest(UUID id, String titulo, Date dataHora, boolean finalizado, String categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.data_hora = dataHora;
		this.finalizado = finalizado;
		this.categoria_name = categoria;
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

	public boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getCategoria_name() {
		return categoria_name;
	}

	public void setCategoria_name(String categoria) {
		this.categoria_name = categoria;
	}
	
}
