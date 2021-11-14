package org.serratec.backend.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Produto;

public interface ProdutoService {

	 List<Produto> pesquisarTodos();
	    Optional<Produto> pesquisarUm(Long idProduto);
	    Produto inserir(Produto produto);
	    Produto editar(Produto produto);
	    boolean idExiste(Long id);
	    void remover(Long id);
}
