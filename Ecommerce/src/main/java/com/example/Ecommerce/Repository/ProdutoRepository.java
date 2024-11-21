package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Integer> {

}
