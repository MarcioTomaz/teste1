package com.example.teste_tecnico_.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "telefone")
public class Telefone extends DomainEntity{

    private String nr_telefone;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Cliente cliente;

    public Telefone(Telefone telefone) {
        setId(telefone.getId());
        this.nr_telefone = telefone.getNr_telefone();
        this.cliente = telefone.getCliente();
    }

    public Telefone(String nrTelefone, Cliente client) {
        this.nr_telefone = nrTelefone;
        this.cliente = client;
    }
}
