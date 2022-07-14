package br.com.dashwork.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
@Embeddable
public class Aparelho {
	@NotNull
	@NotEmpty(message = "campo - MARCA - obrigatório!")
	private String marca;
	@NotNull
	@NotEmpty(message = "campo - TIPO - obrigatório!")
	private String tipo;
	@NotNull
	@NotEmpty(message = "campo - MODELO - obrigatório!")
	private String modelo;
	@NotNull
	@NotEmpty(message = "campo - DEFEITO - obrigatório!")
	private String defeito;

}
