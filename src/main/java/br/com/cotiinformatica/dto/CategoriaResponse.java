package br.com.cotiinformatica.dto;

import java.util.UUID;

import br.com.cotiinformatica.entities.Categoria;

public class CategoriaResponse {
	private UUID id;
	private String nome;
	
	public CategoriaResponse() {
		super();
	}

	public CategoriaResponse(UUID id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Categoria toEntity(CategoriaResponse request) {
		Categoria categoria = new Categoria(request.getId(), request.getNome(), new java.util.ArrayList<>());
		return categoria;
	}
	
	public static CategoriaResponse fromEntity(Categoria categoria) {
		CategoriaResponse response = new CategoriaResponse(categoria.getId(), categoria.getNome());
		return response;
	}
	
}
