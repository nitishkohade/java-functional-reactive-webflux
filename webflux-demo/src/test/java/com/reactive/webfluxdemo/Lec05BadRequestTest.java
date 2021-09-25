package com.reactive.webfluxdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.reactive.webfluxdemo.dto.MultiplyRequestDto;
import com.reactive.webfluxdemo.dto.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lec05BadRequestTest extends BaseTest{

	@Autowired
	private WebClient webClient;
	
	@Test
	public void badRequestTest() {
		Flux<Response> responseMono = this.webClient
		.post()
		.uri("reactive-math/square/{number}/throw", 5)
		.retrieve()
		.bodyToFlux(Response.class)
		.doOnNext(System.out::println)
		.doOnError(System.out::println);
		
		StepVerifier.create(responseMono)
			.verifyError(WebClientResponseException.BadRequest.class);
	}
	
}
