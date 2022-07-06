package br.com.dashwork.infra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.dashwork.domain.Servico;
@Repository
public interface ServicoRepositoryDB extends JpaRepository<Servico, Long>{

}
