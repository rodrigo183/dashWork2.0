package br.com.dashwork.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
@Entity
@Table(name = "servico")
public class Servico {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotNull
	private Cliente cliente;
	@Valid
	private Aparelho aparelho;
}
