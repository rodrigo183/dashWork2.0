package br.com.dashwork.application.api.request;
import javax.validation.Valid;

import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Servico;
import br.com.dashwork.domain.ServicoStatus;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServicoAtualizaRequest {

	@Valid
	private Aparelho aparelho;
	private ServicoStatus status;

	public Servico toEntidade() {
		return Servico.builder().aparelho(aparelho).status(status).build();
	}
}
