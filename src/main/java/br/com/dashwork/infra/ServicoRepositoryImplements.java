package br.com.dashwork.infra;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.com.dashwork.application.service.ServicoService;
import br.com.dashwork.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
@AllArgsConstructor
@Log4j2
@Getter
@Setter
@Repository
@Primary
public class ServicoRepositoryImplements implements ServicoService {
	
	@Autowired
	private ServicoRepositoryDB servicoRepository;

	@Override
	public Servico salva(@Valid Servico servico) {
		log.info("[Inicia] ServicoService - salva ");
		Servico novoServico = servicoRepository.save(servico);
		log.info("[Finaliza] ServicoService - salva");
		return novoServico;
	}

	@Override
	public List<Servico> listaServicos() {
		log.info("[Inicia] ServicoService - listaServicos ");
		List<Servico> todosServicos = servicoRepository.findAll();
		log.info("[Finaliza] ServicoService - listaServicos");
		return todosServicos;
	}

	@Override
	public List<Servico> buscaServicoPorClienteId(UUID clienteId) {
		log.info("[Inicia] ServicoService - buscaServicosPorIdCliente ");
		List<Servico> servico = servicoRepository.findByClienteId(clienteId);
		log.info("[Finaliza] ServicoService - buscaServicosPorIdCliente ");
		return servico;
	}

	@Override
	public Servico atualiza(@Valid UUID servicoId, @Valid Servico servico) {
		log.info("[Inicia] ServicoService - atualiza");
		Servico servicoAtualizado = servicoRepository.getById(servicoId);
		log.info("[Finaliza] ServicoService - atualiza ");
		return servicoRepository.save(servicoAtualizado);
	}

	@Override
	public Optional<Servico> buscaServicoPorId(@Valid UUID servicoId) {
		log.info("[Inicia] ServicoService - buscaServicoPorId");
		Optional<Servico> servicoPorId = servicoRepository.findById(servicoId);
		log.info("[Finaliza] ServicoService - buscaServicoPorId");
		return servicoPorId;
	}

	@Override
	public void deleta(UUID servicoId) {
		log.info("[Inicia] ServicoService - deleta ");	
		servicoRepository.inativaServico(servicoId);
		log.info("[Finaliza] ServicoService - deleta ");
	}

}
