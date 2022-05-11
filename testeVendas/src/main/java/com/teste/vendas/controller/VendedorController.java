package com.teste.vendas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.teste.vendas.dominio.Vendedor;
import com.teste.vendas.repository.VendedorRepository;
import com.teste.vendas.service.VendedorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	private VendedorService vendedorService;
	
	@GetMapping("/vendedor")
	public List<Vendedor> listar() {
		return vendedorRepository.findAll();
	}
	
	@GetMapping("/vendedor/{vendedorId}")
	public ResponseEntity<Vendedor> buscar (@PathVariable Long vendedorId){
		return vendedorRepository.findById(vendedorId)
				.map(ResponseEntity:: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/vendedor")
	@ResponseStatus( HttpStatus.CREATED)
	public Vendedor adicionar (@Valid @RequestBody Vendedor vendedor ) {
		return vendedorService.salvar(vendedor);
	}
	@PutMapping("/vendedor/{vendedorId}")
	public ResponseEntity<Vendedor> atualizar (@Valid @RequestBody Vendedor vendedor, @PathVariable Long vendedorId){
		if(!vendedorRepository.existsById(vendedorId)) {
			return ResponseEntity.notFound().build();
		}
		vendedor.setId(vendedorId);
		vendedor= vendedorService.salvar(vendedor);
		
		return ResponseEntity.ok(vendedor);
		
		
	}
	@DeleteMapping("/vendedor/{vendedorId}")
	public ResponseEntity<Void> deletar (@PathVariable Long vendedorId){
		if(!vendedorRepository.existsById(vendedorId)) {
			return ResponseEntity.notFound().build();
		
	}
	 vendedorService.excluir(vendedorId);
	 return ResponseEntity.noContent().build();
		 

 }
}