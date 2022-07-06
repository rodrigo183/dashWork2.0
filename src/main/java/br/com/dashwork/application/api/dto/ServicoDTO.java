package br.com.dashwork.application.api.dto;
import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Servico;
import lombok.Getter;
@Getter
public class ServicoDTO {

	private Long id;
	private Long clienteId;
	private Aparelho aparelho;
	
	public ServicoDTO(Servico servico) {
		this.id =servico.getId();
		this.clienteId = servico.getCliente().getId();
		this.aparelho = servico.getAparelho();
	}
}
