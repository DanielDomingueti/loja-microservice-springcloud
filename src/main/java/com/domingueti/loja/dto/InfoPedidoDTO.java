package com.domingueti.loja.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class InfoPedidoDTO {

	private Long id;
	private Integer tempoDePreparo;
	
}
