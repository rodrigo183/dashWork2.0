package br.com.dashwork.application.api.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Servico;
import br.com.dashwork.domain.ServicoStatus;
import lombok.Getter;

@Getter
public class ServicoResponse {

	private UUID id;
	private LocalDateTime inicio;
	private LocalDateTime conclusao;
	private ServicoStatus status;
	private UUID clienteId;
	private Aparelho aparelho;
	private boolean ativo;

	public ServicoResponse(Servico servico) {
		this.id =servico.getId();
		this.status = servico.getStatus();
		this.clienteId = servico.getCliente().getId();
		this.aparelho = servico.getAparelho();
		this.inicio = servico.getInicio();
		this.conclusao = servico.getConclusao();
		this.ativo = servico.isAtivo();
			}

	public static List<ServicoResponse> parseListResponse(List<Servico> listaServicos) {
		return listaServicos.stream().map(ServicoResponse::new).collect(Collectors.toList());
	}
}
