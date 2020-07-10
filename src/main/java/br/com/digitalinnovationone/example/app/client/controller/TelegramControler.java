package br.com.digitalinnovationone.example.app.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.digitalinnovationone.example.app.client.dto.MessageSend;
import br.com.digitalinnovationone.example.app.client.dto.ResultBotTelegramList;
import br.com.digitalinnovationone.example.app.client.service.Telegram;

@RestController
@RequestMapping("/v1/telegram")
public class TelegramControler {

	private Telegram telegram;
	private ObjectMapper objectMapper;
	
	public TelegramControler(Telegram soldadoService, ObjectMapper objectMapper) {
		this.telegram = soldadoService;
		this.objectMapper = objectMapper;
	}
	
	@PostMapping
	public ResponseEntity criarSoldado(@RequestBody MessageSend messageRequest) {
		System.out.println("Entrou no post");
		telegram.enviarMensagem(messageRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<ResultBotTelegramList> buscarSoldados() {
		ResultBotTelegramList getUpdatesResultBotTelegram = telegram.buscarAtualizacao();
		return ResponseEntity.ok(getUpdatesResultBotTelegram);
	}
}
