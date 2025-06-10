package br.com.cotiinformatica.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dto.TarefaRequest;
import br.com.cotiinformatica.dto.TarefaResponse;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import br.com.cotiinformatica.repositories.TarefaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tarefas")
@Tag(name = "Tarefas", description = "Acesso às operações do resource tarefa.")
public class TarefasController {

	@Autowired TarefaRepository tarefaRepository;
	@Autowired CategoriaRepository categoriaRepository;
	@Autowired ModelMapper mapper;
	
	@PostMapping
	@Operation(
	  summary = "Criar tarefa", 
	  description = "Cria uma nova tarefa com os dados enviados no body da requisição.",
	  responses = {
        @ApiResponse(responseCode = "201", description = "Tarefa criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro ao criar tarefa")
	  }
	)
	public ResponseEntity<TarefaResponse> create(
		@RequestBody @Valid TarefaRequest tarefa
	) throws ParseException {
		
		var cat = categoriaRepository.findById(tarefa.getCategoriaId())
			.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

		var entity = mapper.map(tarefa, Tarefa.class);
		  entity.setId(UUID.randomUUID());
			entity.setCategoria(cat);

		entity = tarefaRepository.save(entity);

		var tarefaResp = mapper.map(entity, TarefaResponse.class);

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(tarefaResp);
	}
	
	@GetMapping("{dataMin}/{dataMax}")
	@Operation(summary = "Listar tarefas", description = "Listar todas as tarefas armazenadas.")
	public List<TarefaResponse> getAll(
		@PathVariable("dataMin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataMin, 
		@PathVariable("dataMax") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataMax
	) {

		var fim = dataMax.atTime(23, 59, 59);
		var inicio = dataMin.atStartOfDay();
		
		var dataMinus = Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant());
		var dataPlus = Date.from(fim.atZone(ZoneId.systemDefault()).toInstant());

		var tarefas = tarefaRepository.findByDatas(dataMinus, dataPlus);

		return tarefas.stream()
			.map(t -> mapper.map(t, TarefaResponse.class))
			.toList();
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Recuperar tarefas", description = "Pega uma tarefa específica pelo seu uuid.")
	public TarefaResponse get(@PathVariable UUID id) {
		var entity = tarefaRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Tarefa nao encontrada"));

		return mapper.map(entity, TarefaResponse.class);
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Excluir tarefa", description = "Exclui definitivamente uma tarefa específica pelo seu uuid.")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		var entity = tarefaRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Tarefa nao encontrada"));

		tarefaRepository.delete(entity);

		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	@Operation(summary = "Atualizar tarefa", description = "Atualiza uma tarefa uma tarefa específica pelo seu uuid e dados enviados no body da requisição.")
	public TarefaResponse update(
			@PathVariable UUID id, 
			@RequestBody TarefaRequest tarefa
	) {
		tarefaRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Tarefa nao encontrada"));

		var cat = categoriaRepository.findById(tarefa.getCategoriaId())
			.orElseThrow(() -> new IllegalArgumentException("Categoria nao encontrada"));
		
		var entity = mapper.map(tarefa, Tarefa.class);
			entity.setId(id);
			entity.setCategoria(cat);

		entity = tarefaRepository.save(entity);
		
		return mapper.map(entity, TarefaResponse.class);
	}
	
}
