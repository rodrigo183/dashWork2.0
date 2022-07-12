package br.com.dashwork.application.api.controller;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.ServicoAPI;
import br.com.dashwork.application.api.dto.ServicoResponse;
import br.com.dashwork.application.api.form.ServicoRequest;
import br.com.dashwork.application.service.ServicoService;
import br.com.dashwork.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@AllArgsConstructor
@CrossOrigin
@RestController
@Log4j2
public class ServicoController implements ServicoAPI {

	@Autowired
	private ServicoService servicoService;
	
	@Override
	public ResponseEntity<ServicoResponse> cadastra(@Valid ServicoRequest servicoForm, UriComponentsBuilder uriBuilder) {
		log.info("[Inicia] ServicoController - cadastra");
		log.info("Form: {}", servicoForm);
		Servico servicoSalvo = servicoService.salva(servicoForm.toEntidade());
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(servicoSalvo.getId()).toUri();
		log.info("[Finaliza] ServicoController - cadastra");
		return ResponseEntity.created(uri).body(new ServicoResponse(servicoSalvo));
	}

	@Override
	public List<ServicoResponse> listaServicos() {
		log.info("[Inicia] ServicoController - listaServicos");
		List<Servico> listaServicos = servicoService.listaServicos();
		log.info("[Finaliza] ServicoController - listaServicos");
		return ServicoResponse.parseListDTO(listaServicos);
	}

	@Override
	public List<ServicoResponse> listaPorCliente(UUID clienteId) {
		log.info("[Inicia] ServicoController - listaPorCliente");
		List<Servico> listaServicos = servicoService.buscaServicosPorClienteId(clienteId);
		log.info("[Finaliza] ServicoController - listaPorCliente");
		return ServicoResponse.parseListDTO(listaServicos);
	}

}
