package com.ByCodersTec.service.Impl;

import com.ByCodersTec.enuns.TipoTransacao;
import com.ByCodersTec.model.TransacaoModel;
import com.ByCodersTec.repository.TransacaoRepository;
import com.ByCodersTec.service.TransacaoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    final private TransacaoRepository transacaoRepository;

    public TransacaoServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public void salvarTransacoes(List<String> linhasDoArquivo) {

        for (String linha : linhasDoArquivo) {
            TransacaoModel transacao = parseLinha(linha);
            if (transacao != null) {
                salvarTransacoes(transacao);

            }
        }
    }

    private void salvarTransacoes(TransacaoModel transacao) {

        var aux = transacaoRepository.findByCpf(transacao.getCpf());

        if (Objects.isNull(aux)) {
            switch (Objects.requireNonNull(TipoTransacao.getByValue(Integer.parseInt(transacao.getTipo())))) {
                case BOLETO, FINANCIAMENTO, ALUGUEL  -> transacao.setValor(transacao.getValor().multiply(BigDecimal.valueOf(-1)));
            }
            transacaoRepository.save(transacao);
        } else {

            switch (Objects.requireNonNull(TipoTransacao.getByValue(Integer.parseInt(transacao.getTipo())))) {
                case DEBITO, RECEBIMENTO_DOC, RECEBIMNETO_TED, VENDAS, RECEBIMENTO_EMPRESTIMO, CREDITO ->
                        aux.incrementaValor(transacao.getValor());
                case BOLETO, FINANCIAMENTO, ALUGUEL -> aux.decrementarValor(transacao.getValor());

            }

            transacaoRepository.save(aux);
        }
    }

    @Override
    public List<TransacaoModel> listarTransacoes() {
        return transacaoRepository.findAll();
    }

    private TransacaoModel parseLinha(String linha) {
        try {
            if (linha.length() != 80) {
                return null;
            }
            var transacao = new TransacaoModel();
            transacao.setTipo(linha.substring(0, 1));
            transacao.setData(LocalDate.parse(linha.substring(1, 9), DateTimeFormatter.ofPattern("yyyyMMdd")));
            transacao.setValor(new BigDecimal(linha.substring(9, 19)).divide(BigDecimal.valueOf(100.00)));
            transacao.setCpf(linha.substring(19, 30));
            transacao.setCartao(linha.substring(30, 42));
            transacao.setHora(LocalTime.parse(linha.substring(42, 48), DateTimeFormatter.ofPattern("HHmmss")));
            transacao.setDonoDaLoja(linha.substring(48, 62));
            transacao.setNomeDaLoja(linha.substring(62, 80));

            return transacao;

        } catch (Exception e) {
            System.err.println("Erro ao analisar linha: " + e.getMessage());
            return null;
        }
    }
}
