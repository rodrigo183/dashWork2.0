package br.com.dashwork.application.api.request;
import javax.validation.Valid;

import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Cliente;
import br.com.dashwork.domain.Servico;
import br.com.dashwork.domain.ServicoStatus;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ServicoRequest {
	@Valid
	private Aparelho aparelho;
	private ServicoStatus status;
	private Long clienteId;
			
	public Servico toEntidade() {
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);
		return Servico.builder().aparelho(aparelho).status(status).cliente(cliente).build();
	}
}
