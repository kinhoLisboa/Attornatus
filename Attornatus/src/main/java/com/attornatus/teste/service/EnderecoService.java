package com.attornatus.teste.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attornatus.teste.domain.Endereco;
import com.attornatus.teste.exception.NegocioException;
import com.attornatus.teste.repository.EnderecoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {

	private EnderecoRepository enderecoRepository;
	
	@Transactional
	public Endereco salvar(Endereco endereco){
		boolean logEmUso = enderecoRepository.findByLogradouro(endereco.getLogradouro())
				.stream()
				.anyMatch(enderecoExistente-> !enderecoExistente.equals(endereco));
		
		if(logEmUso) {
			throw new NegocioException("Endereco ja existente com esse logradouro");
		}
		
			return enderecoRepository.save(endereco);
		
	}

	@Transactional
	public List<Endereco> listar() {

		return enderecoRepository.findAll();
	}
	@Transactional
	public ResponseEntity<Endereco> atualizar( Endereco endereco,Long enderecoId) {
		if (!enderecoRepository.existsById(enderecoId)) {
			return ResponseEntity.notFound().build();
		}
		endereco.setId(enderecoId);
		enderecoRepository.save(endereco);
		return ResponseEntity.ok().build();

	}

	@Transactional
	public void deletar(Long enderecoId) {

		enderecoRepository.deleteById(enderecoId);
	}


}
