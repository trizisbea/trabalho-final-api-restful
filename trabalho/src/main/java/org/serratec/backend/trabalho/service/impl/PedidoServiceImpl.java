package org.serratec.backend.trabalho.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Pedido;
import org.serratec.backend.trabalho.domain.PedidoItem;
import org.serratec.backend.trabalho.domain.PedidoItemPK;
import org.serratec.backend.trabalho.dto.PedidoDTO;
import org.serratec.backend.trabalho.dto.PedidoItemRequestDTO;
import org.serratec.backend.trabalho.dto.PedidoRequestDTO;
import org.serratec.backend.trabalho.repository.PedidoRepository;
import org.serratec.backend.trabalho.repository.ProdutoRepository;
import org.serratec.backend.trabalho.service.ClienteService;
import org.serratec.backend.trabalho.service.PedidoService;
import org.serratec.backend.trabalho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
    private PedidoRepository pedidoRepository;
	
	@Autowired
    private ProdutoRepository produtoRepository;
	
	@Autowired
    private ClienteService clienteService;
	
	@Autowired
    private ProdutoService produtoService;

	@Override
    public List<PedidoDTO> pesquisarTodos() {
 		List<Pedido> pedidos = pedidoRepository.findAll();
 		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
 		
 		for (Pedido pedido : pedidos) {
 			PedidoDTO pedidoDTO = new PedidoDTO(pedido); 
 			pedidosDTO.add(pedidoDTO);
 		}
        return pedidosDTO;
    }
	

    @Override
    public Optional<Pedido> pesquisarUm(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    /*@Override
    public Pedido inserir(Pedido pedido) {
    
        return pedidoRepository.save(pedido);
    	//return null;
    }*/
    
    @Override
    public Pedido inserir(PedidoRequestDTO pedido) {
		//Optional<Pedido> pe = pedidoRepository.findById(pedido.getIdPedido());
		
		Pedido p = new Pedido();
		p.setCliente(clienteService.pesquisarUm(pedido.getIdCliente()).get());
		List<PedidoItem> lista = new ArrayList(); 
		pedidoRepository.save(p); 
		p.setIdPedido(pedidoRepository.count());
		
		
		for (PedidoItemRequestDTO pe : pedido.getItensPedido()) {
			PedidoItem pi = new PedidoItem(new PedidoItemPK(p,produtoService.pesquisarUm(pe.getIdProduto()).get()),pe.getQuantidadeProduto()); 
			lista.add(pi); 
			
		}
		p.setPedidoItem(lista);
		return pedidoRepository.save(p);
		}
   

    @Override
    public boolean idExiste(Long idPedido) {
        return pedidoRepository.existsById(idPedido);
    }

    @Override
    public void remover(Long idPedido) {
    	pedidoRepository.deleteById(idPedido);
    }

    
    @Override
    public PedidoDTO atualizar(Long id,Pedido pedido) {
        pedido.setIdPedido(id);
        pedidoRepository.save(pedido);
        PedidoDTO pDto = new PedidoDTO(pedido);
        return pDto;
    }


}
