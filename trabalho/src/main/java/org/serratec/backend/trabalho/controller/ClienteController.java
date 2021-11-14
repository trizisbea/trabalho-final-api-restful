package org.serratec.backend.trabalho.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.domain.Endereco;
import org.serratec.backend.trabalho.dto.ClienteDTO;
import org.serratec.backend.trabalho.repository.ClienteRepository;
import org.serratec.backend.trabalho.service.ClienteService;
import org.serratec.backend.trabalho.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController 
@RequestMapping("/clientes")
public class ClienteController {
	
	//PUT, POST e GET por id 
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private ClienteDTO clienteDTO; 
	
	@Autowired 
	private EnderecoService enderecoService; 
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os clientes cadastrados", notes = "listagem de clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<List<ClienteDTO>> pesquisarTodos() {
		return ResponseEntity.ok(clienteService.pesquisarTodos());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna cliente cadastrado", notes = "retorna cliente por id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna cliente"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<Cliente> pesquisarUm(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
	}
		return ResponseEntity.notFound().build();		

}


	@PostMapping
    @ApiOperation(value = "Cadastra cliente", notes = "cadastro de clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente adicionado"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção"),
    })
    public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente, UriComponentsBuilder b) {
        Cliente client = clienteService.inserir(cliente);
        UriComponents uriComponents = b.path("/clientes/{id}").buildAndExpand(cliente);
        Endereco endereco = enderecoService.buscar(cliente.getCep());
        cliente.setEndereco(endereco);
        return ResponseEntity.created(uriComponents.toUri()).body(cliente);
    }
	
	
	@PutMapping("/{id}")
    @ApiOperation(value = "Atualiza cliente cadastrado", notes = "atualizar clientes por id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Cliente atualizado"),
        @ApiResponse(code = 401, message = "Erro de autenticação"),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
        @ApiResponse(code = 404, message = "Recurso não encontrado"),
        @ApiResponse(code = 505, message = "Ocorreu uma exceção"),
    })
    public ResponseEntity<ClienteDTO> editar(@Valid @RequestBody Cliente cliente, @PathVariable Long id) {
        if (!clienteService.idExiste(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setIdCliente(id);
        cliente = clienteService.atualizar(id, cliente);
        ClienteDTO cDto = new ClienteDTO(cliente);
        return ResponseEntity.ok(cDto);
}
}
