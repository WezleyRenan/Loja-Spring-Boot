package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ven_vendas")
public class VendasModel {

    @Id
    @Column(name = "ven_nr_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pro_nr_id")
    private int produto;

    @Column(name = "loj_nr_id")
    private int loja;

}
