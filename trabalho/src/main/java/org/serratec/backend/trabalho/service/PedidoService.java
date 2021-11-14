package org.serratec.backend.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Pedido;
import org.serratec.backend.trabalho.dto.PedidoDTO;
import org.serratec.backend.trabalho.dto.PedidoRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface PedidoService {
	
		List<PedidoDTO> pesquisarTodos();
	    Optional<Pedido> pesquisarUm(Long idPedido);
	    Pedido inserir(PedidoRequestDTO pedido);
	    //Pedido inserir(Pedido pedido);
	    PedidoDTO atualizar(Long id, Pedido pedido);
		boolean idExiste(Long idPedido);
		void remover(Long idPedido);

}
