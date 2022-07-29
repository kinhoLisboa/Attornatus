package com.attornatus.teste.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataHora(LocalDateTime.now());
		problema.setMensagen("Um ou mais campos estão inválidos, preencha corretamente ou tente mais tarde.");
		
	
		return handleExceptionInternal(ex, problema, headers, status, request);
	}

}
