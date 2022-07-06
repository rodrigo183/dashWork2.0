package br.com.dashwork.application.api.controller;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.ServicoAPI;
import br.com.dashwork.application.api.dto.ServicoDTO;
import br.com.dashwork.application.api.form.ServicoForm;
import br.com.dashwork.application.service.ServicoService;
import br.com.dashwork.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@AllArgsConstructor
@CrossOrigin
@RestController
public class ServicoController implements ServicoAPI {
	private ServicoService servicoService;
	
	@Override
	public ResponseEntity<ServicoDTO> cadastra(@Valid ServicoForm servicoForm, UriComponentsBuilder uriBuilder) {
		log.info("[Inicia] ServicoController - cadastra");
		log.info("Form: {}", servicoForm);
		Servico servicoSalvo = servicoService.salva(servicoForm.toEntidade());
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(servicoSalvo.getId()).toUri();
		log.info("[Finaliza] ServicoController - cadastra");
		return ResponseEntity.created(uri).body(new ServicoDTO(servicoSalvo));
	}

}
