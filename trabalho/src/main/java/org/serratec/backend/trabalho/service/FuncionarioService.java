package org.serratec.backend.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Funcionario;

public interface FuncionarioService {
		 List<Funcionario> pesquisarTodos();
		    Optional<Funcionario> pesquisarUm(Long idFuncionario);
		    Funcionario inserir(Funcionario funcionario);
		    boolean idExiste(Long id);
		    void remover(Long id);

	}

