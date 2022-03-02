package com.dlisboa.danifleiksonapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlisboa.danifleiksonapi.exception.RegraNegocioException;
import com.dlisboa.danifleiksonapi.modelo.Pessoa;
import com.dlisboa.danifleiksonapi.repositorio.RepositorioPessoa;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PessoaService {
	
	private RepositorioPessoa repositorioPessoa;
	
	
	@Transactional
	public Pessoa salvar (Pessoa pessoa) {
	boolean emailEmUso =repositorioPessoa.findByEmail(pessoa.getEmail())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(pessoa));
	if (emailEmUso) {
		throw new RegraNegocioException("Este email ja se encontra em uso, tente com email diferente.");
	}
		
		return repositorioPessoa.save(pessoa);
		
	}
	
	@Transactional
	public void excluir (Long pessoaId) {
		repositorioPessoa.deleteById(pessoaId);
	}

}
