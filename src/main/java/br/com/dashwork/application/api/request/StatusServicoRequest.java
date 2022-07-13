package br.com.dashwork.application.api.request;

import br.com.dashwork.domain.Servico;
import br.com.dashwork.domain.ServicoStatus;

public class StatusServicoRequest {
	private ServicoStatus status;

	public Servico toEntidade() {
		return Servico.builder().status(status).build();
	}
}
