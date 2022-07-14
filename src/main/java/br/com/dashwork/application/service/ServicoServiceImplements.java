package br.com.dashwork.application.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	private ServicoRepository servicoRepository;

	@Override
	public Servico salva(@Valid Servico servico) {
		log.info("[Inicia] ServicoServiceImplements - salva ");
		Servico novoServico = servicoRepository.salva(servico);
		log.info("[Finaliza] ServicoServiceImplementes - salva");
		return novoServico;
	}

	@Override
	public List<Servico> listaServicos() {
		log.info("[Inicia] ServicoServiceImplements - listaServicos ");
		List<Servico> todosServicos = servicoRepository.buscaServicos();
		log.info("[Finaliza] ServicoServiceImplements - listaServicos");
		return todosServicos;
	}

	@Override
	public List<Servico> buscaServicosPorClienteId(Long clienteId) {
		log.info("[Inicia] ServicoServiceImplements - buscaServicoPorClienteId ");
		List<Servico> servicos = servicoRepository.buscaServicosPorClienteId(clienteId);
		log.info("[Finaliza] ServicoServiceImplements - buscaServicoPorClienteId ");
		return servicos;

	}

	@Override
	public Optional<Servico> buscaServicoPorId(@Valid Long servicoId) {
		log.info("[Inicia] ServicoServiceImplements - buscaServicoPorId ");
		Optional<Servico> servicoPorId = servicoRepository.buscaServicoPorId(servicoId);
		servicoPorId.orElseThrow(() -> new IllegalArgumentException("servico não encontrado!"));
		log.info("[Finaliza] ServicoServiceImplements - buscaServicoPorId ");
		return servicoPorId;
	}

	@Override
	public Servico atualiza(@Valid Long servicoId, @Valid Servico servico) {
		log.info("[Inicia] ServicoServiceImplements - atualiza ");
		buscaServicoPorId(servicoId);
		Servico servicoAtualizado = servicoRepository.atualiza(servicoId);
		servicoAtualizado.atualiza(servico);
		log.info("[Finaliza] ServicoServiceImplements - atualiza ");
		return servicoRepository.salva(servicoAtualizado);
	}

	@Override
	public void deleta(@Valid Long servicoId) {
		log.info("[Inicia] ServicoServiceImplements - deleta ");
		buscaServicoPorId(servicoId);
		servicoRepository.remove(servicoId);
		log.info("[Finaliza] ServicoServiceImplements - deleta ");
	}
}
