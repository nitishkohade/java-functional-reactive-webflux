package com.reactive.webfluxdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.reactive.webfluxdemo.dto.InputFailedValidationResponse;
import com.reactive.webfluxdemo.dto.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lec06ExchangeTest extends BaseTest {

	@Autowired
	private WebClient webClient;
	
	@Test
	public void badRequestTest() {
		Mono<Object> responseMono = this.webClient
		.post()
		.uri("reactive-math/square/{number}/throw", 5)
		.exchangeToMono(this::exchange)
		.doOnNext(System.out::println)
		.doOnError(System.out::println);
		
		StepVerifier.create(responseMono)
			.verifyError(WebClientResponseException.BadRequest.class);
	}
	
	private Mono<Object> exchange(ClientResponse cr) {
		if(cr.rawStatusCode() == 400) {
			return cr.bodyToMono(InputFailedValidationResponse.class);
		} else {
			return cr.bodyToMono(Response.class);
		}
	}
	
}
