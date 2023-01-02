package com.example.teste_tecnico_.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cliente")
public class Cliente extends DomainEntity{


    @NotBlank(message = " Informe um nome. ")
    @Size(max = 200, message = "O nome do departamento deve ter no max {max} caracteres. ")
    private String nm_cliente;

    @NotBlank(message = " Informe um email. ")

    private String nm_email;
    @NotBlank(message = " Informe um cep. ")
    private String nm_cep;

    @NotBlank(message = " Informe um endereco. ")
    private String nm_endereco;

    @NotBlank(message = " Informe um bairro. ")
    private String nm_bairro;
    private String nm_complemento;

    @NotBlank(message = " Informe uma cidade. ")
    private String nm_cidade;

    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefoneList;

    public Cliente(Cliente cliente) {
        setId(cliente.getId());
        this.nm_cliente = cliente.getNm_cliente();
        this.nm_bairro = cliente.getNm_bairro();
        this.nm_cidade = cliente.getNm_cidade();
        this.nm_cep = cliente.getNm_cep();
        this.nm_endereco = cliente.getNm_endereco();
        this.nm_email = cliente.getNm_email();
        this.nm_complemento = cliente.getNm_complemento();
    }
}
