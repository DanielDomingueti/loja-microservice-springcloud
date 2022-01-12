package com.domingueti.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.alura.microservice.fornecedor")
public class LojaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}
