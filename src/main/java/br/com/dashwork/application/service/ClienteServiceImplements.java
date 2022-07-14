package br.com.dashwork.application.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.dashwork.application.repository.ClienteRepository;
import br.com.dashwork.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Getter
@Setter
@Service
public class ClienteServiceImplements implements ClienteService {

	private ClienteRepository clienteRepository;

	@Override
	public Cliente salva(@Valid Cliente cliente) {
		log.info("[start] ClienteServiceImplements - adiciona");
		Cliente novoCliente = clienteRepository.salva(cliente);
		log.info("[finish] ClienteServiceImplements - adiciona");
		return novoCliente;
	}

	@Override
	public List<Cliente> buscaTodos() {
		log.info("[start] ClienteServiceImplements - buscaTodos");
		List<Cliente> listaCliente = clienteRepository.buscaTodos();
		log.info("[finish] ClienteServiceImplements - buscaTodos");
		return listaCliente;
	}

	@Override
	public void atualiza(@Valid Long id, @Valid Cliente cliente) {
		log.info("[start] ClienteServiceImplements - atualiza");
		buscaPorId(id);
		Cliente clienteAtualizado = clienteRepository.atualiza(id);
		clienteAtualizado.atualiza(cliente);
		clienteRepository.salva(clienteAtualizado);
		log.info("[finish] ClienteServiceImplements - atualiza");
	}

	@Override
	public Optional<Cliente> buscaPorId(@Valid Long id) {
		log.info("[start] ClienteServiceImplements - buscaPorId ");
		Optional<Cliente> clientePorId = clienteRepository.buscaClientePorId(id);
		clientePorId.orElseThrow(() -> new IllegalArgumentException("cliente não encontrado!"));
		log.info("[finish] ClienteServiceImplements - buscaPorId ");
		return clientePorId;
	}

	@Override
	public void remove(@Valid Long id) {
		log.info("[start] ClienteServiceImplements - deleta ");
		buscaPorId(id);
		clienteRepository.remove(id);
		log.info("[finish] ClienteServiceImplements - deleta ");

	}

}
