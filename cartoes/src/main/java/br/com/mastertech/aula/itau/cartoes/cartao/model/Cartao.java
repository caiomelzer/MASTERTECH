package br.com.mastertech.aula.itau.cartoes.cartao.model;
import javax.persistence.*;

@Entity
@Table
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column
    private String numero;

    private int clienteId;

    @Column
    private Boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public int getCliente() {
        return clienteId;
    }

    public void setCliente(int clienteId) {
        this.clienteId = clienteId;
    }
}
