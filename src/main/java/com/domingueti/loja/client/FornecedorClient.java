package com.domingueti.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.domingueti.loja.dto.InfoFornecedorDTO;
import com.domingueti.loja.dto.InfoPedidoDTO;
import com.domingueti.loja.dto.ItemDaCompraDTO;

@FeignClient(name="fornecedor", url = "http://localhost:8081")
public interface FornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@PostMapping(value = "/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> list);

}
