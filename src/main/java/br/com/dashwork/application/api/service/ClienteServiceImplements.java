package br.com.dashwork.application.api.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Cliente> buscaTodos() {
		log.info("[start] ClienteServiceImplements - buscaTodos");
		List<Cliente> listaCliente = clienteRepository.buscaTodos();
		log.info("[finish] ClienteServiceImplements - buscaTodos");
		return listaCliente;
	}

	@Override
	public void atualiza(Long id, Cliente cliente) {
		log.info("[start] ClienteServiceImplements - atualiza");
		Cliente clienteAtualizado = clienteRepository.getById(cliente);
		clienteAtualizado.atualiza(cliente);
		clienteRepository.save(clienteAtualizado);
		log.info("[finish] ClienteServiceImplements - atualiza");
		
	}
	
	@Override
	public Optional<Cliente> buscaPorId(Long id) {
		log.info("[Inicia] ClienteService - buscaPorId ");
		Optional<Cliente> clientePorId = clienteRepository.findById(id);
		clientePorId.orElseThrow(() -> new IllegalArgumentException("cliente não encontrado!"));
		log.info("[Finaliza] ClienteService - buscaPorId ");
		return clientePorId;
	
}