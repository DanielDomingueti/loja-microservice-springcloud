package com.domingueti.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.domingueti.loja.client.FornecedorClient;
import com.domingueti.loja.dto.CompraDTO;
import com.domingueti.loja.dto.InfoFornecedorDTO;
import com.domingueti.loja.dto.InfoPedidoDTO;
import com.domingueti.loja.model.Compra;

@Service
@EnableFeignClients
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado().toString());
		//info == null
		//compra.getEndereco.getEstado nao esta nulo, assim como compra.getList
		
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getList()); //erro esta aqui
		//pedido retorna erro
		if (info != null) {
			System.out.println(info.getEndereco());
		}

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());

		return compraSalva;

	}

}