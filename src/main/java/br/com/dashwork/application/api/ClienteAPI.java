package br.com.dashwork.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dashwork.application.api.dto.ClienteDTO;
import br.com.dashwork.application.api.form.ClienteForm;

@RequestMapping("/v1/cliente")
public interface ClienteAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<ClienteDTO> cadastra(@RequestBody ClienteForm clienteForm, UriComponentsBuilder uriBuilder);
	
}
