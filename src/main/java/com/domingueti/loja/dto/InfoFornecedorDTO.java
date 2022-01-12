package com.domingueti.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InfoFornecedorDTO {

	private Long id;
	private String nome;
	private String estado;
	private String endereco;
	
}