package com.ByCodersTec.service;

import com.ByCodersTec.model.TransacaoModel;

import java.util.List;

public interface TransacaoService {

    void salvarTransacoes(List<String> linhasDoArquivo);
    List<TransacaoModel> listarTransacoes();
}
