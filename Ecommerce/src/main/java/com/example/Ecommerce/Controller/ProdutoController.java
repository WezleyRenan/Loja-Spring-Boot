package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.ProdutoModel;
import com.example.Ecommerce.Service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/criar")
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto){
        ProdutoModel produtoModel = produtoService.criar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModel);
    }
    @DeleteMapping("/deletar")
    public ResponseEntity<Object> deletar(@PathVariable("id") int id){
        boolean delete = produtoService.deletar(id);
        if (delete){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar (@PathVariable("id") int id , @RequestBody ProdutoModel produto){
        boolean atualize = produtoService.atualizar(id,produto);
        if(atualize){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao encontrado");
    }
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listar());
    }
}
