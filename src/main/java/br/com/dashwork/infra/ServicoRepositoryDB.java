package br.com.dashwork.infra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.dashwork.domain.Servico;
@Repository
public interface ServicoRepositoryDB extends MongoRepository<Servico, Long>{

}
