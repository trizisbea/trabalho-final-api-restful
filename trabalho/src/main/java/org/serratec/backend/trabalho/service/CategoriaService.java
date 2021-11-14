package org.serratec.backend.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Categoria;
import org.serratec.backend.trabalho.domain.Produto;

public interface CategoriaService {
	 List<Categoria> pesquisarTodos();
	    Optional<Categoria> pesquisarUm(Long idCategoria);
	    Categoria inserir(Categoria categoria);
	    Categoria editar(Categoria categoria);
		boolean idExiste(Long idCategoria);
		void remover(Long idCategoria);

}
