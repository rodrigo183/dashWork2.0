package br.com.dashwork.application.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.dashwork.domain.Servico;
@Repository
public interface ServicoRepository {

	List<Servico> findByClienteIdAndAtivo(UUID clienteId, boolean ativo);
    List<Servico> findAllByAtivo(boolean ativo);
    Optional<Servico>findById(UUID id);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Servico set ativo = false where id =:id", nativeQuery = true)
    void inativaServico(@Param("id")UUID id);
    
    @Modifying(clearAutomatically = true)
    @Query(value = "select status from servico where id=:id", nativeQuery = true)
    LocalDate buscaServicoStatus(@Param("id") UUID id);
	Servico getById(@Valid UUID servicoId);
	Servico salva(@Valid Servico servico);
    
}
