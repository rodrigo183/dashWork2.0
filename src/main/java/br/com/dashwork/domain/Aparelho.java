package br.com.dashwork.domain;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
@Embeddable
public class Aparelho {

	@NotNull @NotEmpty(message = "campo - MARCA - obrigatório!") @Size(min=2, max = 255)
    private String marca;
	@NotNull @NotEmpty(message = "campo - TIPO - obrigatório!") @Size(min=2, max = 255)
    private String tipo;
	@NotNull @NotEmpty(message = "campo - MODELO - obrigatório!")@Size(min=2, max = 255)
    private String modelo;
	@NotNull @NotEmpty(message = "campo - DEFEITO - obrigatório!")@Size(min=5, max = 255)
	private String defeito;
}
