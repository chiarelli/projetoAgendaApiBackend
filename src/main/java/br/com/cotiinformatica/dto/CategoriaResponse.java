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
        Categoria categoria = new Categoria();
        categoria.setId(request.getId());
        categoria.setNome(request.getNome());
        categoria.setTarefas(null);
        return categoria;
    }
	
	public static CategoriaResponse fromEntity(Categoria categoria) {
		CategoriaResponse request = new CategoriaResponse();
		request.setId(categoria.getId());
		request.setNome(categoria.getNome());
		return request;
	}
	
}
