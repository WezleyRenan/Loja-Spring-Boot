package com.example.Ecommerce.Controller;


import com.example.Ecommerce.Model.VendasModel;
import com.example.Ecommerce.Service.VendasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("vendas")
public class VendasController {

    private final VendasService vendasService;

    @PostMapping("/criar")
    public ResponseEntity<VendasModel> criar(@RequestBody VendasModel vendas){
        VendasModel vendasModel = vendasService.criar(vendas);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendasModel);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletar (@PathVariable("id") int id){
        boolean delete = vendasService.deletar(id);
        if(delete){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id da venda nao encontrado, nao foi possivel deletar");

    }
    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizar(@PathVariable("id") int id, @RequestBody VendasModel vendas){
        boolean atualiza = vendasService.atualizar(id, vendas);
        if(atualiza){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("venda não encontrada, não foi possivel atualizar");
    }
    @GetMapping("/listar")
    public ResponseEntity<List<VendasModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.listar());
    }
}
