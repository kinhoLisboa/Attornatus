package com.teste.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.vendas.dominio.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	
	List<Vendedor> findByNome (String nome);

}
