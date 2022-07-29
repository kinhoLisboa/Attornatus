package com.attornatus.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.teste.domain.Pessoa;
import com.attornatus.teste.service.PessoaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class PessoaController {

	private PessoaService pessoaService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/pessoa")
	public Pessoa adicionar (@Valid @RequestBody Pessoa pessoa) {

		return pessoaService.salvar(pessoa);
	
	}

	@GetMapping("/pessoa")
	public List<Pessoa> listar() {

		return pessoaService.listar();
	}

	@GetMapping("/pessoa/{pessoaId}")
	public ResponseEntity<Pessoa> consultar(@PathVariable Long pessoaId) {
		return pessoaService.buscar(pessoaId);

	}

	@PutMapping("/pessoa/{pessoaId}")
	public ResponseEntity<Pessoa> atualizar(@Valid @RequestBody Pessoa pessoa,@PathVariable Long pessoaId) {
		
		return pessoaService.atualizar(pessoa, pessoaId);

	}

	@DeleteMapping("/pessoa/{pessoaId}")
	public ResponseEntity<Void> deletar(@PathVariable Long pessoaId) {
		return pessoaService.apagar(pessoaId);
	}
	
}
