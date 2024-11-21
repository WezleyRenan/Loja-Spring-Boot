package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.VendasModel;
import com.example.Ecommerce.Repository.VendasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class VendasService {

    private final VendasRepository vendasRepository;

    public VendasModel criar(VendasModel novaVenda){
        return vendasRepository.save(novaVenda);
    }

    public boolean deletar(int id){
        Optional<VendasModel> venda = vendasRepository.findById(id);
        if(venda.isPresent()){
            vendasRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean atualizar(int id, VendasModel vendaAtualizar){
        Optional<VendasModel> vendas = vendasRepository.findById(id);
        if (vendas.isPresent()){
            VendasModel novaVenda = vendas.get();
            novaVenda.setLoja(vendaAtualizar.getLoja());
            novaVenda.setProduto(vendaAtualizar.getProduto());
            vendasRepository.save(novaVenda);
            return true;
        }
        return false;
    }
    public List<VendasModel> listar(){
        return vendasRepository.findAll();
    }

}
