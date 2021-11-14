package org.serratec.backend.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.dto.ClienteDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
	public interface ClienteService {
	List<ClienteDTO> pesquisarTodos();
    Optional<Cliente> pesquisarUm(Long idCliente);
    Cliente inserir(Cliente cliente);
    Cliente atualizar(Long id, Cliente cliente);
	boolean idExiste(Long idCliente);
	void remover(Long idCliente);
	

}
