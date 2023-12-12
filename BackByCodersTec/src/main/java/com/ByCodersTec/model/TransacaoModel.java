package com.ByCodersTec.model;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


@Data
@Entity
@Table
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String cartao;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(nullable = false)
    private String donoDaLoja;

    @Column(nullable = false)
    private String nomeDaLoja;


    public void incrementaValor(BigDecimal valor){
        this.valor = this.valor.add(valor);
    }
    public void decrementarValor(BigDecimal valor){
        this.valor = this.valor.subtract(valor);
    }


}
