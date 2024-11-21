package com.example.Ecommerce.Service;


import com.example.Ecommerce.Model.ProdutoModel;
import com.example.Ecommerce.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoModel criar(ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    public boolean deletar(int id){
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        if (produto.isPresent()){
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean atualizar(int id, ProdutoModel produto){
        Optional<ProdutoModel> lojaModel = produtoRepository.findById(id);
        if(lojaModel.isPresent()) {
            ProdutoModel novoProduto = lojaModel.get();
            novoProduto.setNome(produto.getNome());
            produtoRepository.save(novoProduto);
            return true;
        }
        return false;
    }
    public List<ProdutoModel> listar(){
        return produtoRepository.findAll();
    }


}
