
package com.example.teste_tecnico_.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTelefoneDTO {

    private String nr_telefone;

    private Long clienteId;
}
