package br.com.gustavoedev.produtos_api.controllers;

import br.com.gustavoedev.produtos_api.dto.ProdutoUpdateDTO;
import br.com.gustavoedev.produtos_api.entities.ProdutoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ArrayList<ProdutoEntity> produtos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<ProdutoEntity> criarProduto(@RequestBody ProdutoEntity produto) {
        produtos.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<ArrayList<ProdutoEntity>> listarProdutos() {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> getProduto(@PathVariable Long id) {
        for (ProdutoEntity produto : produtos) {
            if (produto.getId().equals(id)) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(produto);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> updateProduto(@PathVariable Long id,
                                                       @RequestBody ProdutoUpdateDTO produtoUpdateDTO) {
        for (ProdutoEntity produto : produtos) {
            if (produto.getId().equals(id)) {
                produto.setNome(produtoUpdateDTO.getNome());
                produto.setPreco(produtoUpdateDTO.getPreco());
                produto.setQuantidade(produtoUpdateDTO.getQuantidade());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(produto);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoEntity> deleteProduto(@PathVariable Long id) {
        for (ProdutoEntity produto : produtos) {
            if (produto.getId().equals(id)) {
                produtos.remove(produto);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
