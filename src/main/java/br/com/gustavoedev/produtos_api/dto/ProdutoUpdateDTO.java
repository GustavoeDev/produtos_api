package br.com.gustavoedev.produtos_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoUpdateDTO {

    private String nome;
    private double preco;
    private int quantidade;

}
