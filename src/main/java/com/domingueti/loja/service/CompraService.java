package com.domingueti.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;

import com.domingueti.loja.client.FornecedorClient;
import com.domingueti.loja.dto.CompraDTO;
import com.domingueti.loja.dto.InfoFornecedorDTO;

@Service
@EnableDiscoveryClient
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;
	
	public void realizaCompra(CompraDTO compra) {

	InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
	System.out.println(info.getEndereco());
	}

	
	
}