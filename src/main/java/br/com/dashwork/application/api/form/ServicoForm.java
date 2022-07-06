package br.com.dashwork.application.api.form;
import javax.validation.Valid;
import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Cliente;
import br.com.dashwork.domain.Servico;

public class ServicoForm {

	@Valid
	private Aparelho aparelho;
	private Long clienteId;
			
	public Servico toEntidade() {
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);
		return Servico.builder().aparelho(aparelho).cliente(cliente).build();
	}

}
