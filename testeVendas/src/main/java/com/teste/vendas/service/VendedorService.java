package com.teste.vendas.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.teste.vendas.dominio.Vendedor;
import com.teste.vendas.repository.VendedorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VendedorService {
	
	private VendedorRepository vendedorRepository;
	
	@Transactional
	public Vendedor salvar (Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	@Transactional
	public void excluir (Long vendedorId) {
	     vendedorRepository.deleteById(vendedorId);
		
	}

}
