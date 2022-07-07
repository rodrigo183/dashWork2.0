package br.com.dashwork.application.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.dashwork.domain.Servico;
@Repository
public interface ServicoRepository extends MongoRepository<Servico, Long> {

}
