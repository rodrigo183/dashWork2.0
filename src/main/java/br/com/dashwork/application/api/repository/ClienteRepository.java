package br.com.dashwork.application.api.repository;

import java.util.List;
import java.util.Optional;
import br.com.dashwork.application.api.domain.Cliente;

public interface ClienteRepository {

	Cliente salva(Cliente cliente);
	Optional<Cliente> buscaClientePorId (Long id);
	List<Cliente> buscaTodos();

}
