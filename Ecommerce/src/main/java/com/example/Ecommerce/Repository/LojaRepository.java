package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.LojaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<LojaModel,Integer> {

}
