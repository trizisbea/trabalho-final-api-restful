package org.serratec.backend.trabalho.repository;


import org.serratec.backend.trabalho.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByEmailCliente(String emailCliente);
}
