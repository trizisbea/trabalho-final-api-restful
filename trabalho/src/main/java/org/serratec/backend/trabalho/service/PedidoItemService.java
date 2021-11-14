package org.serratec.backend.trabalho.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.PedidoItem;

public interface PedidoItemService {
	List<PedidoItem> pesquisarTodos();
    Optional<PedidoItem> pesquisarUm(Long idPedidoItem);
    PedidoItem inserir(PedidoItem pedidoItem);
    boolean idExiste(Long idPedidoItem);
    void remover(Long idPedidoItem);
    
    public Long sumQuantities();
    public BigDecimal total(Long idPedido);

}
