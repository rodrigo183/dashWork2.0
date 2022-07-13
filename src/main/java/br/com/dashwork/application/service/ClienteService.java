package br.com.dashwork.application.service;
import java.util.List;
import java.util.Optional;

import br.com.dashwork.domain.Cliente;
public interface ClienteService {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodos();
	void atualiza(Long id, Cliente entidade);
	Optional<Cliente> buscaPorId(Long id);
	void remove(Long id);
	
}
