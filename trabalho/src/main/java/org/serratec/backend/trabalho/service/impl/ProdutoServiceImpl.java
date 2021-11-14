package org.serratec.backend.trabalho.service.impl;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Produto;
import org.serratec.backend.trabalho.repository.ProdutoRepository;
import org.serratec.backend.trabalho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	 @Autowired
	    private ProdutoRepository produtoRepository;

	    @Override
	    public List<Produto> pesquisarTodos() {
	        return produtoRepository.findAll();
	    }

	    @Override
	    public Optional<Produto> pesquisarUm(Long idProduto) {
	        return produtoRepository.findById(idProduto);
	    }

	    @Override
	    public Produto inserir(Produto produto) {
	        return produtoRepository.save(produto);
	    }

	    @Override
	    public boolean idExiste(Long idProduto) {
	        return produtoRepository.existsById(idProduto);
	    }
	    

	    @Override
	    public void remover(Long idProduto) {
	        produtoRepository.deleteById(idProduto);
	    }

		@Override
		public Produto editar(Produto produto) {
			return produtoRepository.save(produto);
		}

}
