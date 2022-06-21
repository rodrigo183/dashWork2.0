package br.com.dashwork.application.api.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.ClienteAPI;
import br.com.dashwork.application.api.domain.Cliente;
import br.com.dashwork.application.api.dto.ClienteDTO;
import br.com.dashwork.application.api.form.ClienteForm;
import br.com.dashwork.application.api.form.ClienteFormAtualiza;
import br.com.dashwork.application.api.service.ClienteService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class ClienteController implements ClienteAPI {
	private ClienteService clienteService;
	
	 @Override
	public ResponseEntity<ClienteDTO> cadastra(ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		Cliente clienteSalvo = clienteService.salva(clienteForm.toEntidade());
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(clienteSalvo.getId()).toUri();
		System.out.println(clienteForm.getNome());
		System.out.println(clienteForm.getTelefone());
		return ResponseEntity.created(uri).body(new ClienteDTO(clienteSalvo));
	 }

	@Override
	public List<ClienteDTO> lista() {
		List<Cliente> cliente = clienteService.buscaTodos();
		return  ClienteDTO.parseListDTO(cliente);
	}

	@Override
	public ResponseEntity<ClienteDTO> atualiza(Long id, ClienteFormAtualiza clienteForm) {
		clienteService.atualiza(id, clienteForm.toEntidade());
		return ResponseEntity.noContent().build();
	}

	 
}
