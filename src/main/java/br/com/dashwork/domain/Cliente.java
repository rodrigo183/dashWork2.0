package br.com.dashwork.domain;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document
public class Cliente {
	@Id
	@Builder.Default
	private UUID id = UUID.randomUUID();
	@NotNull
	private String nome;
	@NotNull
	@Column(unique = true)
	private String telefone;
	
	public void atualiza(Cliente cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}
}
