package org.serratec.backend.trabalho.service.impl;

import java.util.Optional;

import org.serratec.backend.trabalho.domain.Endereco;
import org.serratec.backend.trabalho.repository.EnderecoRepository;
import org.serratec.backend.trabalho.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public Endereco buscar(String cep) {
		Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));
		if(endereco.isPresent()) {
			return new Endereco(endereco.get());
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uri = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(restTemplate.getForObject(uri, Endereco.class));
			if (enderecoViaCep.get().getCep() != null) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				return inserir(enderecoViaCep.get());
			} else {
				return null;
			}
		}
	}

	public Endereco inserir(Endereco endereco) {
		endereco = enderecoRepository.save(endereco);
		return new Endereco(endereco);
	}
}
