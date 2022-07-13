package br.com.dashwork.domain;
import java.time.LocalDate;

import br.com.dashwork.application.service.strategy.TempoDeResposta;
public enum ServicoStatus implements TempoDeResposta {
	PARA_ORCAMENTO{
	@Override
	public LocalDate obtemTempoDeResposta(Long id) {
		return LocalDate.now().plusDays(2);
	}},
	 EM_ORCAMENTO{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(1);
		}
	},
	 AGUARDANDO_AUTORIZACAO{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(2);
		}
	},
	 AUTORIZADO{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(1);
		}
	},
	 AGUARDANDO_MATERIAL{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(7);
		}
	},
	 EM_TESTE{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(1);
		}
	},
	 PRONTO{
		@Override
		public LocalDate obtemTempoDeResposta(Long id){
			return LocalDate.now().plusDays(7);
		}
	},
	 Entregue{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(0);
		}
	},
	Retorno{
		@Override
		public LocalDate obtemTempoDeResposta(Long id) {
			return LocalDate.now().plusDays(2);
		}
	};
}
