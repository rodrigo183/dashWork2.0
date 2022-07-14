package br.com.dashwork.application.repository;

import java.util.List;
import java.util.Optional;

import br.com.dashwork.domain.Servico;

public interface ServicoRepository {
	Servico salva(Servico servico);

	Optional<Servico> buscaServicoPorId(Long servicoId);

	List<Servico> buscaServicosPorClienteId(Long clienteId);

	List<Servico> buscaServicos();

	Servico atualiza(Long servicoId);

	void remove(Long servicoId);

}
