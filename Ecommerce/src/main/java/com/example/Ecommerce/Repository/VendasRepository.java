package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.VendasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<VendasModel,Integer> {


}
