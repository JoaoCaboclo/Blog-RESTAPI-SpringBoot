package com.joaocaboclosf.blog.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public  class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	public ResourceNotFoundException(String message) {
		this(message, null);
	}
	
	public ResourceNotFoundException() {
		this("Recurso não encontrado!");
	}
}
