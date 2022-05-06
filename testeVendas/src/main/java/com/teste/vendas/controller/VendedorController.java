package com.teste.vendas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendedorController {
	
	@GetMapping("/vendedor")
	public String listar() {
		return " teste";
	}

}
