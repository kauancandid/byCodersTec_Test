package com.ByCodersTec.dto;

import com.ByCodersTec.model.TransacaoModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class TransacaoResponseDTO {

    private UUID id;
    private String tipo;
    private LocalDate data;
    private BigDecimal valor;
    private String cpf;
    private String cartao;
    private LocalTime hora;
    private String donoDaLoja;
    private String nomeDaLoja;

    public static TransacaoResponseDTO convertToDTO(TransacaoModel transacaoModel) {
        var transacaoResponseDTO = new TransacaoResponseDTO();
        transacaoResponseDTO.setId(transacaoModel.getId());
        transacaoResponseDTO.setTipo(transacaoModel.getTipo());
        transacaoResponseDTO.setData(transacaoModel.getData());
        transacaoResponseDTO.setValor(transacaoModel.getValor());
        transacaoResponseDTO.setCpf(transacaoModel.getCpf());
        transacaoResponseDTO.setCartao(transacaoModel.getCartao());
        transacaoResponseDTO.setHora(transacaoModel.getHora());
        transacaoResponseDTO.setDonoDaLoja(transacaoModel.getDonoDaLoja());
        transacaoResponseDTO.setNomeDaLoja(transacaoModel.getNomeDaLoja());

        return transacaoResponseDTO;
    }
}