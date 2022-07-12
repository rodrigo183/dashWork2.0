package br.com.dashwork.application.service;
import java.util.List;
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
	public List<Servico> buscaServicosPorClienteId(UUID clienteId) {
		log.info("[Inicia] ServicoService - buscaServicosPorIdCliente ");
		List<Servico> servicos = servicoRepository.findByClienteId(clienteId);
		log.info("[Finaliza] ServicoService - buscaServicosPorIdCliente ");
		return servicos;
	}

}
