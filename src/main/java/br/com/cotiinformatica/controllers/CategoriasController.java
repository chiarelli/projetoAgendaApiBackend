package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		var response = categorias.stream()
			.map(cat -> CategoriaResponse.fromEntity(cat))
			.toList();
		
		return response;
	}
	
	@GetMapping("{name}")
	@Operation(summary = "Retornar uma categoria", description = "Retorna uma categoria específica pelo seu uuid.")
	public CategoriaResponse getByName(@PathVariable String name) {
		var cat = repository.findByName(name);
		return CategoriaResponse.fromEntity(cat);
	}
	
}
