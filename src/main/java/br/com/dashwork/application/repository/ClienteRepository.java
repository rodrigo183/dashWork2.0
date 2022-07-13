package br.com.dashwork.application.repository;
import java.util.List;
import java.util.Optional;

import br.com.dashwork.domain.Cliente;
public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	Optional<Cliente> buscaClientePorId (Long id);
	List<Cliente> buscaTodos();
	Cliente getById(Long id);
	void remove(Long id);

}
