package br.com.dashwork.application.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import br.com.dashwork.domain.Servico;
public interface ServicoService {
	Servico salva(Servico servico);
	List<Servico> listaServicos();
	Servico atualiza(UUID id, Servico entidade);
	List<Servico> buscaServicoPorClienteId(UUID clieteId);
	Optional<Servico> buscaServicoPorId(UUID id);
	void deleta(UUID id); 
}
