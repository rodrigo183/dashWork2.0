package br.com.dashwork.application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.dashwork.domain.Servico;
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}