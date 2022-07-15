package br.com.dashwork.application.api.request;

import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Cliente;
import br.com.dashwork.domain.Servico;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServicoRequest {

	private Aparelho aparelho;
	private Long clienteId;

	public Servico toEntidade() {
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);
		return Servico.builder().aparelho(aparelho).cliente(cliente).build();
	}
}
