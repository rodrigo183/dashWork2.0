package br.com.dashwork.domain;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
public class Servico {

	@Id
	private Long Id;
	@NotNull
	private Cliente cliente;
	@Valid
	private Aparelho aparelho;
}
