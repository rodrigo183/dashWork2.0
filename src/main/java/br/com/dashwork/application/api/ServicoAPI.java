package br.com.dashwork.application.api;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.dto.ServicoDTO;
import br.com.dashwork.application.api.form.ServicoForm;

@RequestMapping("/v1/servico")
public interface ServicoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<ServicoDTO> cadastra(@RequestBody @Valid ServicoForm servicoForm, UriComponentsBuilder uriBuilder);

}
