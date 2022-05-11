package com.teste.vendas.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Vendedor {
	
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Column(name="TOTALVENDAS")
	private String totalVendas;
	
	@NotBlank
	@Column(name="MEDIAVENDAS")
	private String mediaVendas;

}
