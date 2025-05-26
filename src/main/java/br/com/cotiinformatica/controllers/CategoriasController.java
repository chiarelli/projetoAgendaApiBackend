package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dto.CategoriaResponse;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "Categorias", description = "Acesso às operações do resource categoria.")
public class CategoriasController {
	
	@Autowired CategoriaRepository repository;

	@GetMapping
	@Operation(summary = "Listar categorias", description = "Listar todas as categorias cadastradas.")
	public List<CategoriaResponse> getAll() {
		var categorias = repository.findAll();
		var mapper = new ModelMapper();

		var response = categorias.stream()
			.map(cat -> mapper.map(cat, CategoriaResponse.class))
			.toList();
		
		return response;
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Retornar uma categoria", description = "Retorna uma categoria específica pelo seu uuid.")
	public ResponseEntity<CategoriaResponse> getById(@PathVariable UUID id) {
		var cat = repository.findById(id);
		return cat.isPresent()
		? ResponseEntity.ok(CategoriaResponse.fromEntity(cat.get()))
		: ResponseEntity.notFound().build();
	}
	
	/*
	@GetMapping
	@Operation(summary = "Listar categorias", description = "Listar todas as categorias cadastradas.")
	public List<CategoriaResponse> getAll() {
		var categorias = repository.findAll();
		var response = categorias.stream()
			.map(CategoriaResponse::fromEntity)
			.toList();
		
		return response;
	}
	*/
}
