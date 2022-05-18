package com.meu.teste.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/funcionarios/{funcionarioId}")
	public ResponseEntity<Funcionario> buscar (@PathVariable Long funcionarioId){
		return funcionarioRepository.findById(funcionarioId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
				
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/funcionarios")
	public Funcionario adicionar (@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@PutMapping("funcionarios/{funcionarioId}")
	public ResponseEntity<Funcionario> atualizar (@PathVariable Long funcionarioId,@RequestBody Funcionario funcionario){
		if(!funcionarioRepository.existsById(funcionarioId)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(funcionarioId);
		funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);
	}
	
	@DeleteMapping("/funcionarios/{funcionarioId}")
	public ResponseEntity<Void> excluir(@PathVariable Long funcionarioId){
		if(!funcionarioRepository.existsById(funcionarioId)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(funcionarioId);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping("/funcionarios/{funcionarioId}")
	public ResponseEntity<Funcionario> atualizarPorDado (@PathVariable Long funcionarioId,@RequestBody Funcionario funcionario){
		if(!funcionarioRepository.existsById(funcionarioId)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(funcionarioId);
		funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);
	
	
	}
}
