package org.serratec.backend.trabalho.service.impl;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.trabalho.domain.Funcionario;
import org.serratec.backend.trabalho.repository.FuncionarioRepository;
import org.serratec.backend.trabalho.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> pesquisarTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Optional<Funcionario> pesquisarUm(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

    @Override
    public Funcionario inserir(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public boolean idExiste(Long idFuncionario) {
        return funcionarioRepository.existsById(idFuncionario);
    }

    @Override
    public void remover(Long idFuncionario) {
    	funcionarioRepository.deleteById(idFuncionario);
    }


}
