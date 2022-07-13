package br.com.dashwork.infra;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import br.com.dashwork.application.repository.ClienteRepository;
import br.com.dashwork.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
@Repository
@AllArgsConstructor
@Log4j2
@Getter
@Setter
public class ClienteRepositoryImplements implements ClienteRepository {

	private ClienteRepositoryDB clienteRepository;
	
	@Override
	public Cliente salva(@Valid Cliente cliente) {
		log.info("[start] ClienteRepositoryImplements - adiciona");
		Cliente novoCliente = clienteRepository.save(cliente);
		log.info("[finish] ClienteRepositoryImplements - adiciona");
		return novoCliente;
	}

	@Override
	public Optional<Cliente> buscaClientePorId(UUID id) {
		log.info("[start] ClienteRepositoryImplements - buscaPorId");
		Optional<Cliente> cliente = clienteRepository.findById(id);
		log.info("[finish] ClienteRepositoryImplements - buscaPorId");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodos() {
		log.info("[start] ClienteRepositoryImplements - buscaTodos");
		List<Cliente> listaTodos = clienteRepository.findAll();
		log.info("[finish] ClienteRepositoryImplements - buscaTodos");
		return listaTodos;
	}

	@Override
	public Cliente getById(UUID id) {
		log.info("[start] ClienteRepositoryImplements - adiciona");
		Cliente clienteEncontrado = clienteRepository.getById(id);
		log.info("[finish] ClienteRepositoryImplements - adiciona");
		return clienteEncontrado;
	}

	@Override
	public void remove(UUID id) {
		log.info("[start] ClienteRepositoryImplements - deleta");
		clienteRepository.deleteById(id);
		log.info("[finish] ClienteRepositoryImplements - adiciona");
		
	}

}
