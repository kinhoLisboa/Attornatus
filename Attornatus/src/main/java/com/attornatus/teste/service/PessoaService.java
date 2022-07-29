package com.attornatus.teste.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attornatus.teste.domain.Pessoa;
import com.attornatus.teste.repository.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

	private PessoaRepository pessoaRepository;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {


		return pessoaRepository.save(pessoa);

	}

	@Transactional
	public List<Pessoa> listar() {

		return pessoaRepository.findAll();

	}

	@Transactional
	public ResponseEntity<Pessoa> buscar(Long pessoaId) {
		return pessoaRepository.findById(pessoaId)
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}
	@Transactional
	public ResponseEntity<Pessoa> atualizar( Pessoa pessoa, Long pessoaId) {
		if (!pessoaRepository.existsById(pessoaId)) {
			return ResponseEntity.notFound().build();
		}
		pessoa.setId(pessoaId);
		pessoaRepository.save(pessoa);
		return ResponseEntity.ok().build();

	}

	@Transactional
	public ResponseEntity<Void> apagar(Long pessoaId) {
		if (!pessoaRepository.existsById(pessoaId)) {
			return ResponseEntity.notFound().build();
		}
		pessoaRepository.deleteById(pessoaId);
		return ResponseEntity.noContent().build();
	}

}
