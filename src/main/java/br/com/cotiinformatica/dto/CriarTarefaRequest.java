package br.com.cotiinformatica.dto;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CriarTarefaRequest {

	@NotBlank(message = "O título é obrigatório.")
	private String titulo;

	@NotNull
	@FutureOrPresent(message = "A data deve ser atual ou futura.")
	private Date data_hora;

	private boolean finalizado;

	@NotNull
	private UUID categoria_id;
	
	public CriarTarefaRequest() {
		super();
	}

	public CriarTarefaRequest(String titulo, Date dataHora, boolean finalizado, UUID categoria_id) {
		super();
		this.titulo = titulo;
		this.data_hora = dataHora;
		this.finalizado = finalizado;
		this.categoria_id = categoria_id;
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

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public UUID getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(UUID categoria) {
		this.categoria_id = categoria;
	}

	public boolean isFinalizado() {
		return finalizado;
	}
	
	@Override
	public String toString() {
		return "CriarTarefaRequest [titulo=" + titulo + ", data_hora=" + data_hora + ", finalizado=" + finalizado
				+ ", categoria_id=" + categoria_id + "]";
	}
	
}
