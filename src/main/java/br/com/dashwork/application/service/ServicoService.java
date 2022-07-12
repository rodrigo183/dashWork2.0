package br.com.dashwork.application.service;
import java.util.List;
import java.util.UUID;

import br.com.dashwork.domain.Servico;

public interface ServicoService {
	Servico salva(br.com.dashwork.domain.Servico entidade);
	List<Servico> listaServicos();
	List<Servico> buscaServicosPorClienteId(UUID clieteId);
}
