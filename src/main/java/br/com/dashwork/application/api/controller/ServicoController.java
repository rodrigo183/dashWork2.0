package br.com.dashwork.application.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dashwork.application.api.ServiceAPI;
import br.com.dashwork.application.api.request.ServicoRequest;
import br.com.dashwork.application.api.request.ServicoRequestAtualiza;
import br.com.dashwork.application.api.response.ServicoResponse;
import br.com.dashwork.application.service.ServicoService;
import br.com.dashwork.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class ServicoController implements ServiceAPI {
	
	private ServicoService servicoService;

	@Override
	public ResponseEntity<ServicoResponse> cadastra(ServicoRequest servicoRequest, UriComponentsBuilder uriBuilder) {
		log.info("[Inicia] ServicoController - cadastra");
		log.info("Form: {}", servicoRequest);
		Servico servicoSalvo = servicoService.salva(servicoRequest.toEntidade());
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(servicoSalvo.getId()).toUri();
		log.info("[Finaliza] ServicoController - cadastra");
		return ResponseEntity.created(uri).body(new ServicoResponse(servicoSalvo));
	}

	@Override
	public List<ServicoResponse> listaServicos() {
		log.info("[Inicia] ServicoController - listaServicos");
		List<Servico> listaServicos = servicoService.listaServicos();
		log.info("[Finaliza] - ServicoController - listaServicos");
		return ServicoResponse.parseListResponse(listaServicos);
	}

	@Override
	public List<ServicoResponse> buscaServicosPorClienteId(Long clienteId) {
		log.info("[Inicia] ServicoController - listaAtravesDoCliente ");
		List<Servico> listaServicos = servicoService.buscaServicosPorClienteId(clienteId);
		log.info("[Finaliza] - ServicoController - listaAtravesDoCliente ");
		return ServicoResponse.parseListResponse(listaServicos);
	}

	@Override
	public ResponseEntity<ServicoResponse> atualiza(Long servicoId, ServicoRequestAtualiza servicoRequest) {
		log.info("[Inicia]  ServicoRestController - atualiza");
		log.info("Form: {}", servicoRequest);
		servicoService.atualiza(servicoId, servicoRequest.toEntidade());
		log.info("[Finaliza] ServicoRestController - atualiza ");
		return ResponseEntity.accepted().build();
	}

	@Override
	public ResponseEntity<ServicoResponse> deleta(Long id) {
		log.info("[Inicia] ServicoController - deleta");
		servicoService.deleta(id);
		log.info("[Finaliza] ServicoController - deleta");
		return ResponseEntity.accepted().build();
	}
}
