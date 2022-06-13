package br.com.dashwork.application.api.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.dashwork.application.api.domain.Cliente;
import br.com.dashwork.application.api.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@AllArgsConstructor
@Getter
@Setter
public class ClienteServiceImplements implements ClienteService {

	private ClienteRepository clienteRepository;

	@Override
	public Cliente salva(@Valid Cliente cliente) {
		log.info("[start] ClienteServiceImplements - adiciona");
		Cliente novoCliente = clienteRepository.salva(cliente);
		log.info("[finish] ClienteServiceImplements - adiciona");
		return novoCliente;
	}
	
}
