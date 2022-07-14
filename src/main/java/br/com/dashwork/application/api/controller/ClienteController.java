package br.com.dashwork.application.api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dashwork.application.api.ClienteAPI;
import br.com.dashwork.application.api.request.ClienteRequest;
import br.com.dashwork.application.api.request.ClienteRequestAtualiza;
import br.com.dashwork.application.api.response.ClienteResponse;
import br.com.dashwork.application.service.ClienteService;
import br.com.dashwork.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@RestController
@Log4j2
public class ClienteController implements ClienteAPI {
	private ClienteService clienteService;

	@Override
	public ResponseEntity<ClienteResponse> cadastra(ClienteRequest clienteForm, UriComponentsBuilder uriBuilder) {
		log.info("[start] ClienteServiceImplements - cadastra");
		Cliente clienteSalvo = clienteService.salva(clienteForm.toEntidade());
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(clienteSalvo.getId()).toUri();
		log.info("[finish] ClienteServiceImplements - cadastra");
		return ResponseEntity.created(uri).body(new ClienteResponse(clienteSalvo));
	}

	@Override
	public List<ClienteResponse> lista() {
		log.info("[start] ClienteServiceImplements - buscaTodos");
		List<Cliente> cliente = clienteService.buscaTodos();
		log.info("[finish] ClienteServiceImplements - buscaTodos");
		return ClienteResponse.parseListDTO(cliente);
	}

	@Override
	public void atualiza(Long id, @Valid ClienteRequestAtualiza clienteForm) {
		log.info("[start] ClienteServiceImplements - atualiza");
		clienteService.atualiza(id, clienteForm.toEntidade());
		log.info("[finish] ClienteServiceImplements - atualiza");
	}

	@Override
	public void deleta(Long id) {
		log.info("[start] ClienteServiceImplements - deleta");
		clienteService.remove(id);
		log.info("[finish] ClienteServiceImplements - deleta");
	}
}
