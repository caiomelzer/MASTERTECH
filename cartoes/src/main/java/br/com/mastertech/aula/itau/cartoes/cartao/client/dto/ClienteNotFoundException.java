package br.com.mastertech.aula.itau.cartoes.cartao.client.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cliente não encontrado")
public class ClienteNotFoundException extends RuntimeException {
}
