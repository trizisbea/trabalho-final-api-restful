package org.serratec.backend.trabalho.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.config.MailConfig;
import org.serratec.backend.trabalho.domain.Cliente;
import org.serratec.backend.trabalho.dto.ClienteDTO;
import org.serratec.backend.trabalho.exception.EmailException;
import org.serratec.backend.trabalho.repository.ClienteRepository;
import org.serratec.backend.trabalho.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	 @Autowired
	 private ClienteRepository clienteRepository;
	 
	 @Autowired
	 private MailConfig mailConfig;
	 
	 
	 	@Override
	    public List<ClienteDTO> pesquisarTodos() {
	 		List<Cliente> clientes = clienteRepository.findAll();
	 		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
	 		
	 		for (Cliente cliente : clientes) {
	 			ClienteDTO clienteDTO = new ClienteDTO(cliente); 
	 			clientesDTO.add(clienteDTO);
	 		}
	        return clientesDTO;
	    }
	 	
	 	
	 
	    @Override
	    public Optional<Cliente> pesquisarUm(Long idCliente) {
	        return clienteRepository.findById(idCliente);
	    }
	  
	    
	    @Override
	    public Cliente inserir(Cliente cliente) {
			Cliente usuarioBanco = clienteRepository.findByEmailCliente(cliente.getEmailCliente());
			if (usuarioBanco != null) {
				throw new EmailException("Email já existente"); 

			}
			Cliente usuario = new Cliente();
			usuario.setNomeCliente(cliente.getNomeCliente()); 
			usuario.setEmailCliente(cliente.getEmailCliente());
			//clienteRepository.save(usuario);  
			
			mailConfig.enviarEmail(cliente.getEmailCliente(), "Cadastro concluído com sucesso", cliente.toString());
			return clienteRepository.save(cliente);
			
		}
	    
	    
	    /*@Override
	    public Cliente inserir(Cliente cliente) {
	    	mailConfig.enviarEmail(cliente.getEmailCliente(), "Cadastro/atualização concluído com sucesso", cliente.toString());
	        return clienteRepository.save(cliente);
	    }*/
	      

	    @Override
	    public boolean idExiste(Long idCliente) {
	        return clienteRepository.existsById(idCliente);
	    }

	    @Override
	    public void remover(Long idCliente) {
	    	clienteRepository.deleteById(idCliente);
	    }

	    
	    @Override
        public Cliente atualizar(Long id, Cliente cliente) {
            cliente.setIdCliente(id);
            Optional<Cliente> c = pesquisarUm(id);
            c.get().setNomeCliente(cliente.getNomeCliente());
            c.get().setUsuarioCliente(cliente.getUsuarioCliente());
            c.get().setSenha(cliente.getSenha());
            clienteRepository.save(c.get());

            mailConfig.enviarEmail(cliente.getEmailCliente(), "Cadastro atualizado com sucesso", cliente.toString());
            return cliente;
        }

		 	    
}
