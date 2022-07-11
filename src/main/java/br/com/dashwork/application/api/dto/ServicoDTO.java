package br.com.dashwork.application.api.dto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Servico;
import lombok.Getter;
@Getter
public class ServicoDTO {

	private UUID id;
	private UUID clienteId;
	private Aparelho aparelho;
	
	public ServicoDTO(Servico servico) {
		this.id =servico.getId();
		this.clienteId = servico.getCliente().getId();
		this.aparelho = servico.getAparelho();
	}

	public static List<ServicoDTO> parseListDTO(List<Servico> listaServicos) {
		return listaServicos.stream().map(ServicoDTO::new).collect(Collectors.toList());
	}
}
