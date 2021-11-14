package org.serratec.backend.trabalho.service;

import org.serratec.backend.trabalho.domain.Endereco;


public interface EnderecoService {

	Endereco buscar(String cep);
	Endereco inserir(Endereco endereco);

}
