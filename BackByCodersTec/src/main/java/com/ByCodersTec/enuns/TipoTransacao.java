package com.ByCodersTec.enuns;

public enum TipoTransacao {
    DEBITO(1),
    BOLETO(2),
    FINANCIAMENTO(3),
    CREDITO(4),
    RECEBIMENTO_EMPRESTIMO(5),
    VENDAS(6),
    RECEBIMNETO_TED(7),
    RECEBIMENTO_DOC(8),
    ALUGUEL(9);

    private int value;
    TipoTransacao(int value) {
        this.value = value;
    }

    public static TipoTransacao getByValue(int value) {

        switch (value) {
            case 1:
                return DEBITO;

            case 2:
                return BOLETO;

            case 3:
                return FINANCIAMENTO;

            case 4:
                return CREDITO;

            case 5:
                return RECEBIMENTO_EMPRESTIMO;

            case 6:
                return VENDAS;

            case 7:
                return RECEBIMNETO_TED;

            case 8:
                return RECEBIMENTO_DOC;

            case 9:
                return ALUGUEL;

            default:
                return null;
        }
    }
}
