package com.ByCodersTec.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TransacaoRequestDTO {

    @NotBlank
    private String tipo;

    @NotNull
    private LocalDate data;

    @NotNull
    private BigDecimal valor;

    @NotBlank
    private String cpf;

    @NotBlank
    private String cartao;

    @NotNull
    private LocalTime hora;

    @NotBlank
    private String donoDaLoja;

    @NotBlank
    private String nomeDaLoja;


}
