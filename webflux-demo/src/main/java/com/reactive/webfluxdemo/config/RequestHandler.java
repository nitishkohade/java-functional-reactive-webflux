package com.reactive.webfluxdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.webfluxdemo.dto.InputFailedValidationResponse;
import com.reactive.webfluxdemo.dto.MultiplyRequestDto;
import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.exception.InputValidationException;
import com.reactive.webfluxdemo.service.ReactiveMathService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestHandler {
	
	@Autowired
	private ReactiveMathService mathService;
	
	public Mono<ServerResponse> squareHandler(ServerRequest request) {
		int input = Integer.parseInt(request.pathVariable("input"));
		Mono<Response> responseMono = this.mathService.findSquare(input);
		return ServerResponse.ok().body(responseMono, Response.class);
	}
	
	
	public Mono<ServerResponse> tableHandler(ServerRequest request) {
		int input = Integer.parseInt(request.pathVariable("input"));
		Flux<Response> responseFlux = this.mathService.multiplicationTable(input);
		return ServerResponse.ok().body(responseFlux, Response.class);
	}
	
	
	public Mono<ServerResponse> tableStreamHandler(ServerRequest request) {
		int input = Integer.parseInt(request.pathVariable("input"));
		Flux<Response> responseFlux = this.mathService.multiplicationTable(input);
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(responseFlux, Response.class);
	}
	
	
	public Mono<ServerResponse> multiplyHandler(ServerRequest request) {
		Mono<MultiplyRequestDto> mono = request.bodyToMono(MultiplyRequestDto.class);
		Mono<Response> responseMono = this.mathService.multiply(mono);
		return ServerResponse.ok()
				.body(responseMono, Response.class);
	}
	
	public Mono<ServerResponse> squareHandlerWithValidation(ServerRequest request) {
		int input = Integer.parseInt(request.pathVariable("input"));
		
		if(input<10 || input>20) {
			return Mono.error(new InputValidationException(input));
		}
		
		Mono<Response> responseMono = this.mathService.findSquare(input);
		return ServerResponse.ok().body(responseMono, Response.class);
	}

}
