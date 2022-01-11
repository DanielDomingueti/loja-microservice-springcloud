package com.domingueti.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domingueti.loja.dto.CompraDTO;
import com.domingueti.loja.dto.InfoFornecedorDTO;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Service
@EnableDiscoveryClient
public class CompraService {

	@Autowired
	private DiscoveryClient eurekaClient;
	
	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(CompraDTO compra) {

		ResponseEntity<InfoFornecedorDTO> exchange = 
		client.exchange(
				"http://fornecedor:8081/info/"+compra.getEndereco().getEstado(), 
				HttpMethod.GET, 
				null, 
				InfoFornecedorDTO.class
		); 
		
		eurekaClient.getInstances("fornecedor").stream()
		.forEach(fornecedor -> {
			System.out.println("localhost:"+fornecedor.getPort());
		});
		
		System.out.println(exchange.getBody().getEndereco());
		
	}

	
	
}