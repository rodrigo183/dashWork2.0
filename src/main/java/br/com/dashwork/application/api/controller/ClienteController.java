package br.com.dashwork.application.api.controller;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.dashwork.application.api.ClienteAPI;
import br.com.dashwork.application.api.dto.ClienteDTO;
import br.com.dashwork.application.api.form.ClienteForm;
import br.com.dashwork.application.api.form.ClienteFormAtualiza;
import br.com.dashwork.application.service.ClienteService;
import br.com.dashwork.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@AllArgsConstructor
@RestController
@Log4j2
public class ClienteController implements ClienteAPI {
	
	@Autowired
	private ClienteService clienteService;
	
	 @Override
	public ResponseEntity<ClienteDTO> cadastra(ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		log.info("[start] ClienteServiceImplements - cadastra");
		Cliente clienteSalvo = clienteService.salva(clienteForm.toEntidade());
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(clienteSalvo.getId()).toUri();
		log.info("[finish] ClienteServiceImplements - cadastra");
		return ResponseEntity.created(uri).body(new ClienteDTO(clienteSalvo));
	 }
	 
	@Override
	public List<ClienteDTO> lista() {
		log.info("[start] ClienteServiceImplements - buscaTodos");
		List<Cliente> cliente = clienteService.buscaTodos();
		log.info("[finish] ClienteServiceImplements - buscaTodos");
		return  ClienteDTO.parseListDTO(cliente);
	}
	
	@Override
	public void atualiza(Long id, @Valid ClienteFormAtualiza clienteForm) {
		log.info("[start] ClienteServiceImplements - atualiza");
		clienteService.atualiza( id, clienteForm.toEntidade());
		log.info("[finish] ClienteServiceImplements - atualiza");
	}
	
	@Override
	public void deleta(Long id) {
		log.info("[start] ClienteServiceImplements - deleta");
		clienteService.remove(id);
		log.info("[finish] ClienteServiceImplements - deleta");
	} 
}
