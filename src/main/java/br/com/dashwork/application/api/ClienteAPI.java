package br.com.dashwork.application.api;
import java.util.List;
import java.util.UUID;

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
import br.com.dashwork.application.api.dto.ClienteDTO;
import br.com.dashwork.application.api.form.ClienteForm;
import br.com.dashwork.application.api.form.ClienteFormAtualiza;
@RequestMapping("/v1/cliente")
public interface ClienteAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<ClienteDTO> cadastra(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder);
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ClienteDTO> lista();
	
	@PatchMapping("/{id}")
	@ResponseStatus (value = HttpStatus.NO_CONTENT)
	void atualiza (@PathVariable UUID id, @RequestBody @Valid ClienteFormAtualiza clienteForm);
	
	@DeleteMapping("/{id}")
	@ResponseStatus (value = HttpStatus.NO_CONTENT)
	void deleta(@PathVariable UUID id);
}


