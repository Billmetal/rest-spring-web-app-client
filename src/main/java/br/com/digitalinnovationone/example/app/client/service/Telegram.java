package br.com.digitalinnovationone.example.app.client.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.digitalinnovationone.example.app.client.client.FeingClient;
import br.com.digitalinnovationone.example.app.client.client.JavaHttpClient;
import br.com.digitalinnovationone.example.app.client.client.RestTemplateClient;
import br.com.digitalinnovationone.example.app.client.dto.MessageSend;
import br.com.digitalinnovationone.example.app.client.dto.ResultBotTelegram;
import br.com.digitalinnovationone.example.app.client.dto.ResultBotTelegramList;

@Service
public class Telegram {

	private RestTemplateClient restTemplateClient;
	
	private FeingClient feingClient;
	
	private JavaHttpClient javaHttpClient;
	
	public Telegram(RestTemplateClient restTemplateClient,FeingClient feingClient,JavaHttpClient javaHttpClient) {
		this.restTemplateClient = restTemplateClient;		
		this.javaHttpClient = javaHttpClient;
		this.feingClient = feingClient;
	}
	
	public void enviarMensagem(MessageSend mensagem) {
		ResponseEntity<ResultBotTelegram> resultBotTelegramResponseEntity = feingClient.enviarMensagem(mensagem);
		ResultBotTelegram resultBotTelegram = feingClient.enviarMensagem1(mensagem);
	}
	
	public ResultBotTelegramList buscarAtualizacao() {
		//ResultBotTelegramList resultBotTelegramList = javaHttpClient.buscarAtualizacao();
		
		//ResultBotTelegramList resultBotTelegramList1 = restTemplateClient.buscarAtualizacao();
		
		ResponseEntity<ResultBotTelegramList> resultBotTelegramList = feingClient.buscaratualizacao();
		
		return resultBotTelegramList.getBody();
	}
}
