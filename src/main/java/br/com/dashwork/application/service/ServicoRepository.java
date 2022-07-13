package br.com.dashwork.application.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.dashwork.domain.Servico;
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	List <Servico> findByClienteIdAndAtivo(Long clienteId, boolean ativo);
	List <Servico> findAllByAtivo(boolean ativo);
	Optional<Servico>findById(Long id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Servico set ativo=false where id=:id", nativeQuery = true)
	void inativaServico(@Param("id") Long id);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "select status from servico where id=:id", nativeQuery = true)
	LocalDate buscaServiceStatus(@Param("id") Long id);
	
	
}
