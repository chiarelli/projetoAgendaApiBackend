package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dto.CriarTarefaRequest;
import br.com.cotiinformatica.dto.TarefaRequest;
import br.com.cotiinformatica.dto.TarefaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tarefas")
@Tag(name = "Tarefas", description = "Acesso às operações do resource tarefa.")
public class TarefasController {
	
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
		@RequestBody @Valid CriarTarefaRequest tarefa
																					) {
		var tarefaResp = new TarefaResponse();
			tarefaResp.setId(UUID.randomUUID());
			tarefaResp.setTitulo(tarefa.getTitulo());
			tarefaResp.setData_hora(tarefa.getData_hora());
			tarefaResp.setFinalizado(tarefa.isFinalizado());

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(tarefaResp);
	}
	
	@GetMapping
	@Operation(summary = "Listar tarefas", description = "Listar todas as tarefas armazenadas.")
	public List<TarefaResponse> getAll() {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not yet implemented method getAll");
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Recuperar tarefas", description = "Pega uma tarefa específica pelo seu uuid.")
	public TarefaResponse get(@PathVariable UUID id) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not yet implemented method get");
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Excluir tarefa", description = "Exclui definitivamente uma tarefa específica pelo seu uuid.")
	public void delete(@PathVariable UUID id) {
		throw new UnsupportedOperationException("Not yet implemented method delete");
	}
	
	@PatchMapping("{id}")
	@Operation(summary = "Atualizar tarefa", description = "Atualiza uma tarefa uma tarefa específica pelo seu uuid e dados enviados no body da requisição.")
	public TarefaResponse update(
			@PathVariable UUID id, 
			@RequestBody TarefaRequest tarefa
	) {
		// TODO Implement this method
		throw new UnsupportedOperationException("Not yet implemented method update");
	}
	
}
