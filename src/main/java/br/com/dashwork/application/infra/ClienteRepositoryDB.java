package br.com.dashwork.application.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dashwork.application.api.domain.Cliente;

public interface ClienteRepositoryDB extends JpaRepository<Cliente, Long> {

	
}
