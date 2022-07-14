package br.com.dashwork.application.service;

import java.util.List;
import java.util.Optional;

import br.com.dashwork.domain.Servico;

public interface ServicoService {
	Servico salva(Servico servico);

	List<Servico> listaServicos();

	Servico atualiza(Long id, Servico entidade);

	List<Servico> buscaServicosPorClienteId(Long id);

	Optional<Servico> buscaServicoPorId(Long id);

	void deleta(Long id);
}
