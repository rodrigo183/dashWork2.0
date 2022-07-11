package br.com.dashwork.infra;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.dashwork.domain.Cliente;
@Repository
public interface ClienteRepositoryDB extends MongoRepository<Cliente, UUID> {

	Cliente getById(UUID id);
	
}
