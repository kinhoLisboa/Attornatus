package com.dlisboa.danifleiksonapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dlisboa.danifleiksonapi.modelo.Pessoa;
import com.dlisboa.danifleiksonapi.repositorio.RepositorioPessoa;
import com.dlisboa.danifleiksonapi.service.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoas")
public class PessoaController {
	
	private PessoaService pessoaService;
	private RepositorioPessoa repositorioPessoa;
	
	
	@GetMapping
	public List<Pessoa> listar() {
	 return	repositorioPessoa.findAll();
	
	}
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId){
	    Optional<Pessoa> pessoa = repositorioPessoa.findById(pessoaId);
	    if(pessoa.isPresent()) {
	    	return ResponseEntity.ok(pessoa.get());
	    }
	    return ResponseEntity.notFound().build();
		
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar (@Valid @RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}	
		
	@PutMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> atualizar (@PathVariable Long pessoaId,
			@Valid @RequestBody Pessoa pessoa){
		if(!repositorioPessoa.existsById(pessoaId)){
			return ResponseEntity.notFound().build();
		}
		pessoa.setId(pessoaId);
		pessoa = pessoaService.salvar(pessoa);
		return ResponseEntity.ok(pessoa);
			
	}
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Void> excluir(@PathVariable Long pessoaId) {
		if(!repositorioPessoa.existsById(pessoaId)) {
			return ResponseEntity.notFound().build();
		}
		pessoaService.excluir(pessoaId);
		return ResponseEntity.ok(null);
		
	}
}
