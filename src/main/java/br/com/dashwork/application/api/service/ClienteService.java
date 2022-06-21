package br.com.dashwork.application.api.service;

import java.util.List;
import java.util.Optional;

import br.com.dashwork.application.api.domain.Cliente;

public interface ClienteService {

	Cliente salva(Cliente cliente);

	List<Cliente> buscaTodos();

	void atualiza(Long id, Cliente entidade);

	Optional<Cliente> buscaPorId(Long id);

}
