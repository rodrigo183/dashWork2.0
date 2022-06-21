package br.com.dashwork.application.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import br.com.dashwork.application.api.domain.Cliente;
import br.com.dashwork.application.api.repository.ClienteRepository;
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
	public Cliente salva(Cliente cliente) {
		log.info("[start] ClienteRepositoryImplements - adiciona");
		Cliente novoCliente = clienteRepository.save(cliente);
		log.info("[finish] ClienteRepositoryImplements - adiciona");
		return novoCliente;
	}

	@Override
	public Optional<Cliente> buscaClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodos() {
		log.info("[start] ClienteRepositoryImplements - buscaTodos");
		List<Cliente> listaTodos = new ArrayList<Cliente>();
		log.info("[finish] ClienteRepositoryImplements - buscaTodos");
		return listaTodos;
	}

	@Override
	public void save(Cliente clienteAtualizado) {
		
		
	}

}
