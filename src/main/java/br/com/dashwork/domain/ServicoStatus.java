package br.com.dashwork.domain;

import java.time.LocalDate;
import java.util.UUID;

import br.com.dashwork.application.service.strategy.TempoDeRespota;

public enum ServicoStatus implements TempoDeRespota {
	PARA_ORCAMENTO {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(2);
		}
	},
	EM_ORCAMENTO {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(1);
		}
	},
	AGUARDANDO_AUTORIZACAO {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(2);
		}
	},
	AUTORIZADO {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(1);
		}
	},
	AGUARDANDO_MATERIAL {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(7);
		}
	},
	EM_TESTE {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(1);
		}
	},
	PRONTO {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(7);
		}
	},
	ENTREGUE {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(0);
		}
	},
	RETORNO {
		@Override
		public LocalDate obtemTempoDeResposta(UUID id) {
			return LocalDate.now().plusDays(2);
		}
	};
}
