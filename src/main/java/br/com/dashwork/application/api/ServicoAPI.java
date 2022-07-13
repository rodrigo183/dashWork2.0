package br.com.dashwork.application.api;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.request.ServicoAtualizaRequest;
import br.com.dashwork.application.api.request.ServicoRequest;
import br.com.dashwork.application.api.response.ServicoResponse;
@RestController
@RequestMapping("/v1/servico")
public interface ServicoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ResponseEntity<ServicoResponse> cadastra(@RequestBody @Valid ServicoRequest servicoRequest, UriComponentsBuilder uriBuilder);

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ServicoResponse> listaServicos();
	
	@GetMapping("/{clienteId}")
	@ResponseStatus(value = HttpStatus.OK)
	List<ServicoResponse> listaPorCliente(@PathVariable UUID clienteId);
	
	@PatchMapping("/{servicoId}")
	@Transactional
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	ResponseEntity<ServicoResponse> atualiza ( @PathVariable UUID servicoId, @RequestBody ServicoAtualizaRequest  servicoResquest);
	
	@DeleteMapping("/{id}")
	@Transactional
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	ResponseEntity<ServicoResponse> deleta(@PathVariable UUID id);
}
