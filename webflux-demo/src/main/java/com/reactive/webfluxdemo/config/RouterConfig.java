package com.reactive.webfluxdemo.config;

import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.webfluxdemo.dto.InputFailedValidationResponse;
import com.reactive.webfluxdemo.exception.InputValidationException;

import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {
	
	@Autowired
	private RequestHandler requestHandler;
	
	@Bean
	public RouterFunction<ServerResponse> highLevelRouter() {
		return RouterFunctions.route()
				.path("route", this::serverResponse)
				.build();
	}

	
	private RouterFunction<ServerResponse> serverResponse() {
		return RouterFunctions.route()
				.GET("square/{input}", RequestPredicates.path("*/1?") ,requestHandler::squareHandler)
				.GET("square/{input}", req -> ServerResponse.badRequest().bodyValue("only 10 - 19 is allowed"))
				.GET("table/{input}", requestHandler::tableHandler)
				.GET("table/{input}/stream", requestHandler::tableStreamHandler)
				.POST("multiply", requestHandler::multiplyHandler)
				.GET("square/{input}/validation", requestHandler::squareHandlerWithValidation)
				.onError(InputValidationException.class, exceptionHandler())
				.build();
	}

	private BiFunction<? super Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandler() {
		
		return (err, req) -> {
			InputValidationException ex = (InputValidationException)err;
			InputFailedValidationResponse response = new InputFailedValidationResponse();
			response.setInput(ex.getInput());
			response.setMessage(ex.getMessage());
			response.setErrorCode(ex.getErrorCode());
			return ServerResponse.badRequest().bodyValue(response);
		};
	}
	
	
	
}
