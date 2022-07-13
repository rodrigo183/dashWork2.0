package br.com.dashwork.domain;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "servico")
public class Servico {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Builder.Default
	private LocalDateTime inicio= LocalDateTime.now();;
	private LocalDateTime conclusao;
	@Builder.Default
	@Enumerated(EnumType.STRING)
	private ServicoStatus status = ServicoStatus.EM_ORCAMENTO;
	@NotNull @ManyToOne
	private Cliente cliente;
	@Valid @Embedded
	private Aparelho aparelho;
	@NotNull
	private boolean ativo;
	
	public void atualiza(Servico servico) {
		this.aparelho = servico.getAparelho();
		this.status = servico.getStatus();
	}
}
