package org.serratec.backend.trabalho.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.trabalho.domain.Pedido;
import org.serratec.backend.trabalho.dto.PedidoDTO;
import org.serratec.backend.trabalho.dto.PedidoRequestDTO;
import org.serratec.backend.trabalho.repository.PedidoRepository;
import org.serratec.backend.trabalho.service.PedidoService;
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
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoRepository pedidoRepository; 
	
	
	@GetMapping
	@ApiOperation(value = "Retorna todos os pedidos cadastrados", notes = "listagem de pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<List<PedidoDTO>> pesquisarTodos() {
		return ResponseEntity.ok(pedidoService.pesquisarTodos());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna pedido cadastrado por id", notes = "pedido por número")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<Pedido> pesquisarUm(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		if (pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
	}
		return ResponseEntity.notFound().build();		

}

	
	@PostMapping
	@ApiOperation(value = "Cadastra pedidos", notes = "listagem de pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Pedido adicionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
	public ResponseEntity<Pedido> inserir(@Valid @RequestBody PedidoRequestDTO pedido, UriComponentsBuilder b) {
		Pedido p = pedidoService.inserir(pedido);
		UriComponents uriComponents = b.path("/pedidos/{id}").buildAndExpand(pedido);
		return ResponseEntity.created(uriComponents.toUri()).body(p);
	}
	
	
	@PutMapping("/{id}")
	 @ApiOperation(value = "Atualiza pedido cadastrado", notes = "atualizar pedido por id")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção"),
	})
    public ResponseEntity<PedidoDTO> editar(@Valid @RequestBody Pedido pedido, @PathVariable Long id) {
        if (!pedidoService.idExiste(id)) {
            return ResponseEntity.notFound().build();
        }
        pedido.setIdPedido(id);
        //pedido = pedidoService.inserir(pedido);
        PedidoDTO pDto = new PedidoDTO(pedido);
        return ResponseEntity.ok(pDto);
    }
		
	
}
