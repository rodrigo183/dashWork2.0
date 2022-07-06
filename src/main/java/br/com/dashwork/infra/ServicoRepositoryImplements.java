package br.com.dashwork.infra;
import java.util.List;

import javax.validation.Valid;
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
public class ServicoRepositoryImplements implements ServicoService {
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

}
