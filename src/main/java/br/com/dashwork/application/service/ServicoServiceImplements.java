package br.com.dashwork.application.service;
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
		log.info("[Inicia] ServicoService - salva ");
		Servico novoServico = servicoRepository.save(servico);
		log.info("[Finaliza] ServicoService - salva");
		return novoServico;
	}
}