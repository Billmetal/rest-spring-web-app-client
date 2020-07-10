package br.com.digitalinnovationone.example.app.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleAppClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleAppClientApplication.class, args);
	}

}
