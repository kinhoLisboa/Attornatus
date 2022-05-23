package com.meu.teste.service;

import org.springframework.stereotype.Service;

import com.meu.teste.controller.ViaCepFuncionario;
import com.meu.teste.modelo.Cep;

@Service
public class FuncionarioService {
	
	public static void main(String[] args){
	    Cep cep = ViaCepFuncionario.findCep("45823460");
}
}
	
