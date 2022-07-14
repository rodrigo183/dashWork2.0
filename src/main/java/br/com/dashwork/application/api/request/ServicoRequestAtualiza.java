package br.com.dashwork.application.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.dashwork.domain.Aparelho;
import br.com.dashwork.domain.Servico;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoRequestAtualiza {

	@NotEmpty(message = "Campo deve ser preenchido.")
	@Size(min = 2)
	private Aparelho aparelho;

	public Servico toEntidade() {
		return Servico.builder().aparelho(aparelho).build();
	}
}
