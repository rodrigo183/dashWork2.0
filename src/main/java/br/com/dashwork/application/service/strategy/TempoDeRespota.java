package br.com.dashwork.application.service.strategy;

import java.time.LocalDate;
import java.util.UUID;

public interface TempoDeRespota {
	LocalDate obtemTempoDeResposta(UUID id);
}
