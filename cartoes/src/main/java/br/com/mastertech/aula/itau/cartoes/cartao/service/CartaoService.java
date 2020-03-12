package br.com.mastertech.aula.itau.cartoes.cartao.service;

import br.com.mastertech.aula.itau.cartoes.cartao.client.ClienteClient;
import br.com.mastertech.aula.itau.cartoes.cartao.client.dto.ClienteDTO;
import br.com.mastertech.aula.itau.cartoes.cartao.client.dto.ClienteNotFoundException;
import br.com.mastertech.aula.itau.cartoes.cartao.model.Cartao;
import br.com.mastertech.aula.itau.cartoes.cartao.repository.CartaoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteClient clienteClient;


    public Cartao create(Cartao cartao) {
        ClienteDTO byId = null;
        try {
            byId = clienteClient.getClienteById(cartao.getCliente());
        } catch (FeignException.FeignClientException.NotFound e) {
            throw new ClienteNotFoundException();
        }

        return cartaoRepository.save(cartao);

    }

    public Cartao changeAtivo(String numero, Boolean ativo) {
        Cartao cartao = getByNumero(numero);

        cartao.setAtivo(ativo);

        return cartaoRepository.save(cartao);
    }

    public Cartao getById(Long id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);

        if(!cartaoOptional.isPresent()) {
            throw new ClienteNotFoundException();
        }

        return cartaoOptional.get();
    }

    public Cartao getByNumero(String numero) {
        Optional<Cartao> cartaoOptional = cartaoRepository.getByNumero(numero);

        if(!cartaoOptional.isPresent()) {
            throw new ClienteNotFoundException();
        }

        return cartaoOptional.get();
    }
}
