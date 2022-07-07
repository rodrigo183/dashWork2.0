//package br.com.dashwork.application.api.controller;
//import java.net.URI;
//import java.util.List;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//import br.com.dashwork.application.api.ServicoAPI;
//import br.com.dashwork.application.api.dto.ServicoDTO;
//import br.com.dashwork.application.api.form.ServicoForm;
//import br.com.dashwork.application.service.ServicoService;
//import br.com.dashwork.domain.Servico;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//@AllArgsConstructor
//@CrossOrigin
//@RestController
//@Log4j2
//public class ServicoController implements ServicoAPI {
//	
//	@Autowired
//	private ServicoService servicoService;
//	
//	@Override
//	public ResponseEntity<ServicoDTO> cadastra(@Valid ServicoForm servicoForm, UriComponentsBuilder uriBuilder) {
//		log.info("[Inicia] ServicoController - cadastra");
//		log.info("Form: {}", servicoForm);
//		Servico servicoSalvo = servicoService.salva(servicoForm.toEntidade());
//		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(servicoSalvo.getId()).toUri();
//		log.info("[Finaliza] ServicoController - cadastra");
//		return ResponseEntity.created(uri).body(new ServicoDTO(servicoSalvo));
//	}
//
//	@Override
//	public List<ServicoDTO> listaServicos() {
//		log.info("[Inicia] ServicoController - listaServicos");
//		List<Servico> listaServicos = servicoService.listaServicos();
//		log.info("[Finaliza] ServicoController - listaServicos");
//		return ServicoDTO.parseListDTO(listaServicos);
//	}
//
//}
