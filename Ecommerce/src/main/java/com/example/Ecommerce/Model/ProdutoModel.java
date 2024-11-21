package com.example.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pro_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_nr_id")
    private int id;

    @Column(name = "pro_tx_nome")
    private String nome;

    @Column(name = "pro_nr_quantidade")
    private int quantidade;

    @Column(name = "pro_nr_valor")
    private double valor;

}
