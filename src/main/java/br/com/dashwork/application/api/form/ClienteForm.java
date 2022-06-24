package br.com.dashwork.application.api.form;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import br.com.dashwork.application.api.domain.Cliente;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClienteForm {
	
	@NotEmpty(message = "Campo deve ser preenchido!")@Size(min = 3, max = 255)
	private String nome;
	@NotEmpty(message = "Campo deve ser preenchido!")
	@Pattern(regexp = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$", message = "“O numero de WhatsApp não está em um formato válido!")
	private String telefone;

	public Cliente toEntidade() {
	      return Cliente.builder().nome(nome).telefone(telefone).build();
	
	}
}
