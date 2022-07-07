package br.com.dashwork.infra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.dashwork.domain.Cliente;
@Repository
public interface ClienteRepositoryDB extends MongoRepository<Cliente, Long> {

	Cliente getById(Long id);
	
}
