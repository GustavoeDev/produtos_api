package br.com.gustavoedev.produtos_api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity {
    private Long id;
    private String nome;
    private double preco;
    private int quantidade;
}
