package com.dlisboa.danifleiksonapi.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.dlisboa.danifleiksonapi.modelo.Pessoa;

@Repository
public interface RepositorioPessoa  extends JpaRepositoryImplementation<Pessoa, Long>{
	
	List<Pessoa> findByNome(String nome);
	Optional<Pessoa>  findByEmail(String email);

}
