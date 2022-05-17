package com.meu.teste.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meu.teste.modelo.Funcionario;
import com.meu.teste.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FuncionarioController {

	private FuncionarioRepository funcionarioRepository;
	
	
	@GetMapping("/funcionarios")
	public List<Funcionario> listar (){
		return funcionarioRepository.findAll();
		
	}
	
	
}
