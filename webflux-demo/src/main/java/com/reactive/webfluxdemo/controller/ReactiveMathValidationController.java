package com.reactive.webfluxdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.webfluxdemo.dto.InputFailedValidationResponse;
import com.reactive.webfluxdemo.dto.Response;
import com.reactive.webfluxdemo.exception.InputValidationException;
import com.reactive.webfluxdemo.service.ReactiveMathService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathValidationController {

	@Autowired
	private ReactiveMathService mathService;
	
	@GetMapping("square/{input}/throw")
	public Mono<Response> findSquare(@PathVariable int input) {
		if(input < 10 || input > 20) {
			throw new InputValidationException(input);
		}
		return mathService.findSquare(input);
	}
	
	@GetMapping("square/{input}/throw-mono")
	public Mono<Response> mpnpError(@PathVariable int input) {
		return Mono
				.just(input)
				.handle((integer, sink) -> {
					if(integer < 10 || integer > 20) {
						sink.next(integer);
					} else {
						sink.error(new InputValidationException(integer));
					}
				})
				.cast(Integer.class)
				.flatMap(i -> this.mathService.findSquare(input));
	}
}
