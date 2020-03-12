package br.com.mastertech.aula.itau.cartoes.cartao.client;

import br.com.mastertech.aula.itau.cartoes.cartao.client.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientes")
public interface ClienteClient {

    @GetMapping("/clientes/{clienteId}/")
    ClienteDTO getClienteById(@PathVariable int clienteId);

}
