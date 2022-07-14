package br.com.dashwork.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.dashwork.application.repository.ServicoRepository;
import br.com.dashwork.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Repository
@AllArgsConstructor
@Log4j2
@Getter
@Setter
public class ServicoRespositoryImplements implements ServicoRepository {

	private ServicoRespositoryDB servicoRepository;

	@Override
	public Servico salva(Servico servico) {
		log.info("[Inicia] ServicoServiceImplements - salva ");
		Servico novoServico = servicoRepository.save(servico);
		log.info("[Finaliza] ServicoServiceImplementes - salva");
		return novoServico;
	}

	@Override
	public Optional<Servico> buscaServicoPorId(Long servicoId) {
		log.info("[Inicia] ServicoServiceImplements - buscaPorId ");
		Optional<Servico> servico = servicoRepository.findById(servicoId);
		log.info("[Finaliza] ServicoServiceImplementes - buscaPorId");
		return servico;
	}

	@Override
	public List<Servico> buscaServicosPorClienteId(Long clienteId) {
		log.info("[Inicia] ServicoServiceImplements - servicoPoIdCliente ");
		List<Servico> servicoClienteId = ((ServicoRepository) servicoRepository).buscaServicosPorClienteId(clienteId);
		return servicoClienteId;
	}

	@Override
	public List<Servico> buscaServicos() {
		log.info("[Inicia] ServicoServiceImplements - buscaServico ");
		List<Servico> listaServico = servicoRepository.findAll();
		log.info("[Finaliza] ServicoServiceImplementes - buscaServico");
		return listaServico;
	}

	@Override
	public Servico atualiza(Long servicoId) {
		log.info("[Inicia] ServicoServiceImplements - adiciona");
		Servico servicoEncontrado = servicoRepository.getReferenceById(servicoId);
		log.info("[Inicia] ServicoServiceImplements - adiciona");
		return servicoEncontrado;
	}

	@Override
	public void remove(Long servicoId) {
		log.info("[Inicia] ServicoServiceImplements - deleta");
		servicoRepository.deleteById(servicoId);
		log.info("[Inicia] ServicoServiceImplements - deleta");

	}

}
