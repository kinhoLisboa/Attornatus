package com.attornatus.teste.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.teste.domain.Endereco;
import com.attornatus.teste.service.EnderecoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EnderecoController {
	
	private EnderecoService enderecoService;
	
	
	@PostMapping("/pessoa/endereco")
	public Endereco criarEndPessoa(@RequestBody Endereco endereco){
		
		return enderecoService.salvar(endereco);
	}


}
