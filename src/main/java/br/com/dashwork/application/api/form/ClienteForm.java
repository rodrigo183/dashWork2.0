package br.com.dashwork.application.api.form;

import javax.validation.constraints.NotEmpty;

import br.com.dashwork.application.api.domain.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteForm {
	
	@NotEmpty(message = "Campo deve ser preenchido!")
	private String nome;
	@NotEmpty(message = "Campo deve ser preenchido!")
	private String telefone;

	public Cliente toEntidade() {
	      return Cliente.builder().nome(nome).telefone(telefone).build();
	
	}
	
}
