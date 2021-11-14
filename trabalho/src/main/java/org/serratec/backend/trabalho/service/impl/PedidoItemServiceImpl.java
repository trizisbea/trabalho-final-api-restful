package org.serratec.backend.trabalho.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.trabalho.domain.PedidoItem;
import org.serratec.backend.trabalho.repository.PedidoItemRepository;
import org.serratec.backend.trabalho.service.PedidoItemService;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public class PedidoItemServiceImpl implements PedidoItemService {

     @Autowired
        private PedidoItemRepository pedidoItemRepository;

        @Override
        public List<PedidoItem> pesquisarTodos() {
            return pedidoItemRepository.findAll();
        }

        @Override
        public Optional<PedidoItem> pesquisarUm(Long idPedidoItem) {
            return pedidoItemRepository.findById(idPedidoItem);
        }

        @Override
        public PedidoItem inserir(PedidoItem produto) {
            return pedidoItemRepository.save(produto);
        }

		@Override
		public boolean idExiste(Long idPedidoItem) {
			return true;
		}

		@Override
		public void remover(Long idPedidoItem) {
		}

		@Override
		public Long sumQuantities() {
			return PedidoItemRepository.sumQuantities();
		}

		@Override
		public BigDecimal total(Long idPedido) {
			return PedidoItemRepository.total(idPedido);
		}
		
		
}
