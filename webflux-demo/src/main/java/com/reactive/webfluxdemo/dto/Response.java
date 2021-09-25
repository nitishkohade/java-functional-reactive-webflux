package com.reactive.webfluxdemo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Response {
	
	private Date date = new Date();
	private int output;
	
	public Response(int output) {
		this.output = output;
	}

	public Response() {
		
	}
	
	public int getOutPut() {
		return this.output;
	}
}
