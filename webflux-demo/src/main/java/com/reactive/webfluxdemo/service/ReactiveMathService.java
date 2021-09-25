package com.reactive.webfluxdemo.service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.reactive.webfluxdemo.dto.MultiplyRequestDto;
import com.reactive.webfluxdemo.dto.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveMathService {
	public Mono<Response> findSquare(int input) {
		return Mono.fromSupplier(() -> input * input)
				.map(Response::new);
	}
	public Flux<Response> multiplicationTable(int input) {
		
		List<Response> list = IntStream.rangeClosed(1, 10)
				.peek(i -> SleepUtil.sleepSeconds(1))
				.peek(i -> System.out.println("Math service processing" + i))
				.mapToObj(i -> new Response(i * input))
				.collect(Collectors.toList());
		
		Flux<Response> flux = Flux.fromIterable(list);
		
		return flux;
		
//		return Flux.range(1, 10)
//				.delayElements(Duration.ofSeconds(1))
//				//.doOnNext(i -> SleepUtil.sleepSeconds(1))
//				.doOnNext(i -> System.out.println("reactive math service" + i))
//				.map(i -> new Response(i * input));
	}
	
	public Mono<Response> multiply(Mono<MultiplyRequestDto> monoDto) {
		return monoDto
				.map(dto -> dto.getFirst() * dto.getSecond())
				.map(Response::new);
		
	}
	
	
}
