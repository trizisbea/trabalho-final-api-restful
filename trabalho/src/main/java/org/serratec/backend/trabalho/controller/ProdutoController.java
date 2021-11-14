package org.serratec.backend.trabalho.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalho.domain.Produto;
import org.serratec.backend.trabalho.repository.ProdutoRepository;
import org.serratec.backend.trabalho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@RequestMapping("/produtos") 
	public class ProdutoController {
		
		@Autowired 
		private ProdutoService produtoService;
		
		@Autowired 
		private ProdutoRepository produtoRepository;

		
		@GetMapping 
		@ApiOperation(value = "Retorna todos os produtos cadastrados", notes = "listagem de produtos")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Retorna todos os produtos"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
		})
		public ResponseEntity<List<Produto>> listar() {
			List<Produto> listaProdutos = produtoService.pesquisarTodos();
			return ResponseEntity.ok(listaProdutos);
		}
		
		@GetMapping("/{id}")
		@ApiOperation(value = "Retorna produto cadastrado", notes = "retorna produto por id")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Retorna produto"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
		})
		public ResponseEntity<Produto> pesquisar(@PathVariable Long id) {
			Optional<Produto> produto = produtoService.pesquisarUm(id);
			if (produto.isPresent()) {
				return ResponseEntity.ok(produto.get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		@ApiOperation(value = "Cadastra produtos", notes = "listagem de produtos")
		@ApiResponses(value = {
				@ApiResponse(code = 201, message = "Produto adicionado"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso não encontrado"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
		})
		@ResponseStatus(HttpStatus.CREATED) 
		public Produto inserir(@Valid @RequestBody Produto produto) {
			return produtoRepository.save(produto);
		}
		
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualiza produto cadastrado", notes = "atualizar produtos")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Produto atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
		public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produto, @PathVariable Long id) {
			if (!produtoService.idExiste(id)) {
				return ResponseEntity.notFound().build();
			}
			produto = produtoService.inserir(produto);
			return ResponseEntity.ok(produto);
		}
		
	

}
