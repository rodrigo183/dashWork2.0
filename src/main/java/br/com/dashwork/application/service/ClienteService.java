package br.com.dashwork.application.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.dashwork.domain.Cliente;
public interface ClienteService {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodos();
	void atualiza(UUID id, Cliente entidade);
	Optional<Cliente> buscaPorId(UUID id);
	void remove(UUID id);
	
}
