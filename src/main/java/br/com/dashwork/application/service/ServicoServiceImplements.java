package br.com.dashwork.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dashwork.application.repository.ServicoRepository;
import br.com.dashwork.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
@Getter
@Setter
public class ServicoServiceImplements implements ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public Servico salva(@Valid Servico servico) {
		log.info("[Inicia] ServicoService - salva ");
		servico.setInicio(LocalDateTime.now());
		servico.setAtivo(true);
		Servico novoServico = servicoRepository.salva(servico);
		log.info("[Finaliza] ServicoService - salva");
		return novoServico;
	}

	@Override
	public List<Servico> listaServicos() {
		log.info("[Inicia] ServicoService - listaServicos ");
		List<Servico> todosServicos = servicoRepository.findAllByAtivo(true);
		log.info("[Finaliza] ServicoService - listaServicos");
		return todosServicos;
	}

	@Override
	public List<Servico> buscaServicoPorClienteId(UUID clienteId) {
		log.info("[Inicia] ServicoService - buscaServicoPorIdCliente ");
		List<Servico> servicos = servicoRepository.findByClienteIdAndAtivo(clienteId, true);
		log.info("[Finaliza] ServicoService - buscaServicoPorIdCliente ");
		return servicos;
	}

	@Override
	public Servico atualiza(@Valid UUID servicoId, @Valid Servico servico) {
		log.info("[Inicia] ServicoService - atualiza ");
		buscaServicoPorId(servicoId);
		Servico servicoAtualizado = servicoRepository.getById(servicoId);
		servicoAtualizado.atualiza(servico);
		log.info("[Finaliza] ServicoService - atualiza ");
		return servicoRepository.salva(servicoAtualizado);
	}
	
	@Override
	public Optional<Servico> buscaServicoPorId(@Valid UUID servicoId) {
		log.info("[Inicia] ServicoService - buscaServicoPorId");
		Optional<Servico> servicoPorId = servicoRepository.findById(servicoId);
		servicoPorId.orElseThrow(() -> new IllegalArgumentException("servicoId não encontrado!"));
		log.info("[Finaliza] ServicoService - buscaServicoPorId");
		return servicoPorId;
	}

	@Override
	public void deleta(@Valid UUID servicoId) {
		log.info("[Inicia] ServicoService - deleta ");
		buscaServicoPorId(servicoId);
		servicoRepository.inativaServico(servicoId);
		log.info("[Finaliza] ServicoService - deleta ");
	}
}
