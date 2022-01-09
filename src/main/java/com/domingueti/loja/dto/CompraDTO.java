package com.domingueti.loja.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraDTO {

	private List<ItemDaCompraDTO> list;
	private EnderecoDTO endereco;
}