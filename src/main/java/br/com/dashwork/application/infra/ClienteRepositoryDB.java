package br.com.dashwork.application.infra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dashwork.domain.Cliente;
@Repository
public interface ClienteRepositoryDB extends JpaRepository<Cliente, Long> {
	
}
