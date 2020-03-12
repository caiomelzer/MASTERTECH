package br.com.mastertech.aula.itau.cartoes.cartao.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCartaoRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String numero;

    @NotNull
    private int clienteId;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}
