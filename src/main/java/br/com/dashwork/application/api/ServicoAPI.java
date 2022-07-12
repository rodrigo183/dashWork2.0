package br.com.dashwork.application.api;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.response.ServicoResponse;
import br.com.dashwork.application.api.request.ServicoRequest;

@RequestMapping("/v1/servico")
public interface ServicoAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	ResponseEntity<ServicoResponse> cadastra(@RequestBody @Valid ServicoRequest servicoForm, UriComponentsBuilder uriBuilder);

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ServicoResponse> listaServicos();
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ServicoResponse> listaPorCliente(@PathVariable UUID clienteId);
}
