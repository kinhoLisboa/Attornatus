package com.teste.vendas.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vendas {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDateTime dataVenda;
	private BigDecimal valor;
	@ManyToOne
	private Vendedor vendedor;
	
	

}
