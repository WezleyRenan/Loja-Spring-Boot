package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.LojaModel;
import com.example.Ecommerce.Service.LojaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("loja")
public class LojaController {

    private final LojaService lojaService;

    @PostMapping("/criar")
    public ResponseEntity<LojaModel> criar(@RequestBody LojaModel loja){
        LojaModel lojaModel = lojaService.criar(loja);
        return ResponseEntity.status(HttpStatus.CREATED).body(lojaModel);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletar(@PathVariable("id") int id){
        boolean delete = lojaService.deletar(id);
        if(delete){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loja nao encontrada");

    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable("id") int id, @RequestBody LojaModel loja){
        boolean atualiza = lojaService.atualizar(id,loja);
        if(atualiza){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loja nao encontrada");
    }
    @GetMapping("/listar")
    public ResponseEntity<List<LojaModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(lojaService.listar());
    }


}
