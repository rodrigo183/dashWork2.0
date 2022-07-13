package br.com.dashwork.application.api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dashwork.application.api.request.ClienteRequest;
import br.com.dashwork.application.api.request.ClienteRequestAtualiza;
import br.com.dashwork.application.api.response.ClienteResponse;
@RequestMapping("/v1/cliente")
public interface ClienteAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<ClienteResponse> cadastra(@RequestBody @Valid ClienteRequest clienteForm, UriComponentsBuilder uriBuilder);
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ClienteResponse> lista();
	
	@PatchMapping("/{id}")
	@ResponseStatus (value = HttpStatus.NO_CONTENT)
	void atualiza (@PathVariable Long id, @RequestBody @Valid ClienteRequestAtualiza clienteForm);
	
	@DeleteMapping("/{id}")
	@ResponseStatus (value = HttpStatus.NO_CONTENT)
	void deleta(@PathVariable Long id);
}


