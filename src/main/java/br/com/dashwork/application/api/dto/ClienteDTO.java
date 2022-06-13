package br.com.dashwork.application.api.dto;

import br.com.dashwork.application.api.domain.Cliente;
import lombok.Getter;

@Getter
public class ClienteDTO {
	private Long id;
	private String nome;
	private String telefone;

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}

}