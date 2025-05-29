package br.com.cotiinformatica.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TarefaResponse {
	private UUID id;
	private String titulo;

	@JsonProperty("data")
	private String data;
	
	@JsonProperty("hora")
	private String hora;

	private boolean finalizado;
	private CategoriaResponse categoria;
	
	public TarefaResponse() {
		super();
	}

	public TarefaResponse(UUID id, String titulo, String data, String hora, boolean finalizado, CategoriaResponse categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.finalizado = finalizado;
		this.categoria = categoria;
	}

	public UUID getId() { return id; }
	public void setId(UUID id) { this.id = id; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getData() { return data; }
	public void setData(String data) { this.data = data; }
	public String getHora() { return hora; }
	public void setHora(String hora) { this.hora = hora; }
	public boolean isFinalizado() { return finalizado; }
	public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; }
	public CategoriaResponse getCategoria() { return categoria; }
	public void setCategoria(CategoriaResponse categoria) { this.categoria = categoria; }
	
	
}
