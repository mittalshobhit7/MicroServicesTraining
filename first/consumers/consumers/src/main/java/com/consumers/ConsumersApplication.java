package com.consumers;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.consumers.controller.ConsumerControllerClient;

@SpringBootApplication
public class ConsumersApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(ConsumersApplication.class, args);
		
		ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getEmployee();
	}
	
	@Bean
	public ConsumerControllerClient consumerControllerClient(){
		return new ConsumerControllerClient();
	}

}
