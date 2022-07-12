package br.com.dashwork.application.api.response;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.dashwork.domain.Cliente;
import lombok.Getter;
@Getter
public class ClienteResponse {
	private UUID id;
	private String nome;
	private String telefone;

	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}
	
	public static List<ClienteResponse> parseListDTO(List<Cliente> listaCliente) {
		return listaCliente.stream().map(ClienteResponse::new).collect(Collectors.toList());
	}
}