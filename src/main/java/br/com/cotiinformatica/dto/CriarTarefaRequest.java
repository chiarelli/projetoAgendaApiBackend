package br.com.cotiinformatica.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CriarTarefaRequest {

	@NotBlank(message = "O título é obrigatório.")
	@Size(min = 8, max = 150, message = "O título deve ter entre 8 e 150 caracteres.")
	private String titulo;

	@NotBlank(message = "A data é obrigatória.")
	@Pattern(
		regexp = "^\\d{4}-\\d{2}-\\d{2}$", 
		message = "A data deve estar no formato AAAA-MM-DD."
	)
	private String data;

	@NotBlank(message = "A hora é obrigatória.")
	@Pattern(
		regexp = "^\\d{2}:\\d{2}$",
		message = "A hora deve estar no formato HH:MM."
	)
	private String hora;

	private boolean finalizado;

	@NotNull(message = "A categoria é obrigatória.")
	@JsonProperty("categoria_id")
	private UUID categoriaId;
	
	public CriarTarefaRequest() { super(); }
	
	public CriarTarefaRequest(String titulo, String data, String hora, boolean finalizado, UUID categoriaId) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.finalizado = finalizado;
		this.categoriaId = categoriaId;
	}

	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public String getData() { return data; }
	public void setData(String data) { this.data = data; }
	public String getHora() { return hora; }
	public void setHora(String hora) { this.hora = hora; }
	public boolean isFinalizado() { return finalizado; }
	public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; }
	public UUID getCategoriaId() { return categoriaId; }
	public void setCategoriaId(UUID categoriaId) { this.categoriaId = categoriaId; }

	@Override
	public String toString() {
		return "CriarTarefaRequest [titulo=" + titulo + ", data=" + data + ", hora=" + hora + ", finalizado="
				+ finalizado + ", categoriaId=" + categoriaId + "]";
	}
	
}
