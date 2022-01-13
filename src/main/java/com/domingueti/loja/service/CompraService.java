package com.domingueti.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.domingueti.loja.client.FornecedorClient;
import com.domingueti.loja.dto.CompraDTO;
import com.domingueti.loja.dto.InfoFornecedorDTO;
import com.domingueti.loja.dto.InfoPedidoDTO;
import com.domingueti.loja.model.Compra;

@Service
@EnableFeignClients
public class CompraService{
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		
		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("Buscando informações do fornecedor de " + estado);
		
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("Realizando um pedido.");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getList());
		//pedido retorna erro
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());

		return compraSalva;

	}

}