package br.com.cotiinformatica.dto;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TarefaResponse {
	private UUID id;
	private String titulo;

	@JsonProperty("data_hora")
	private Date dataHora;
	private boolean finalizado;
	private CategoriaResponse categoria;
	
	public TarefaResponse() {
		super();
	}

	public TarefaResponse(UUID id, String titulo, Date data_hora, boolean finalizado, CategoriaResponse categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataHora = data_hora;
		this.finalizado = finalizado;
		this.categoria = categoria;
	}

	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public Date getDataHora() { return dataHora; }
	public void setDataHora(Date data_hora) { this.dataHora = data_hora; }
	public boolean isFinalizado() { return finalizado; }
	public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; }
	public CategoriaResponse getCategoria() { return categoria; }
	public void setCategoria(CategoriaResponse categoria) { this.categoria = categoria; }
	
	
}
