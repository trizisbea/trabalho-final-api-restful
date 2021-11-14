package org.serratec.backend.trabalho.controller;


import org.serratec.backend.trabalho.domain.Endereco;
import org.serratec.backend.trabalho.repository.EnderecoRepository;
import org.serratec.backend.trabalho.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("{cep}")
	@ApiOperation(value = "Retorna o endereço", notes = "endereço a partir do número do CEP")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o endereço"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<Endereco> buscar(@PathVariable String cep) {
		Endereco endereco = enderecoService.buscar(cep);
		
		if (endereco == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(endereco);
		}
}
}