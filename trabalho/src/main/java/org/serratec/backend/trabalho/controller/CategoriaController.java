package org.serratec.backend.trabalho.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.trabalho.domain.Categoria;
import org.serratec.backend.trabalho.domain.Produto;
import org.serratec.backend.trabalho.repository.CategoriaRepository;
import org.serratec.backend.trabalho.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController 
@RequestMapping("/categorias")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@GetMapping 
	@ApiOperation(value = "Retorna todos as categorias cadastradas", notes = "listagem de categorias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos as categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> listaCategorias = categoriaService.pesquisarTodos();
		return ResponseEntity.ok(listaCategorias);
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra categoria", notes = "cadastro de categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Categoria adicionada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	@ResponseStatus(HttpStatus.CREATED) 
	public Categoria inserir(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza categoria cadastrada", notes = "atualizar categorias")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Categoria atualizada"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
})
	public ResponseEntity<Categoria> atualizar(@Valid @RequestBody Categoria categoria, @PathVariable Long id) {
		if (!categoriaService.idExiste(id)) {
			return ResponseEntity.notFound().build();
		}
		categoria = categoriaService.inserir(categoria);
		return ResponseEntity.ok(categoria);
	}

}
