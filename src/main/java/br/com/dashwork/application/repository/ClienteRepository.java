package br.com.dashwork.application.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.dashwork.domain.Cliente;
@Repository
public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	Optional<Cliente> buscaClientePorId (UUID id);
	List<Cliente> buscaTodos();
	Cliente getById(UUID id);
	void remove(UUID id);

}
