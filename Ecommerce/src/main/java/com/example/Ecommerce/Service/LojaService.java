package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.LojaModel;
import com.example.Ecommerce.Repository.LojaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class LojaService {

    private final LojaRepository lojaRepository;

    public LojaModel criar(LojaModel loja){
        return lojaRepository.save(loja);
    }

    public boolean deletar(int id){
        Optional<LojaModel> loja = lojaRepository.findById(id);
        if (loja.isPresent()){
            lojaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean atualizar(int id, LojaModel loja){
        Optional<LojaModel> lojaModel = lojaRepository.findById(id);
        if(lojaModel.isPresent()) {
            LojaModel novaLoja = lojaModel.get();
            novaLoja.setNome(loja.getNome());
            lojaRepository.save(novaLoja);
            return true;
        }
        return false;
    }
    public List<LojaModel> listar(){
        return lojaRepository.findAll();
    }


}
