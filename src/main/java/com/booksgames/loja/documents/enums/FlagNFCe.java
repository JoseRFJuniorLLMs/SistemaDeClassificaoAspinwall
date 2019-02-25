package com.booksgames.loja.documents.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FlagNFCe {

    DINHEIRO(1), CHEQUE(2), CARTAO_DE_CREDITO(3), CARTAO_DE_DEBITO(4), CREDITO_LOJA(5), VALE_ALIMENTACAO(10), VALE_REFEICAO(11),
    VALE_PRESENTE(12), VALE_COMBUSTIVEL(13), BOLETO_BANCARIO(15), SEM_PAGAMENTO(90), OUTROS(99);

    private int flag;

    FlagNFCe(int flag) {
        this.flag = flag;
    }

    @JsonCreator
    public static FlagNFCe parse(int flag) {
        if (flag == 0) {
            return null;
        }
        FlagNFCe flagNFCe = null;

        for (FlagNFCe x : FlagNFCe.values()) {
            if (flag == x.getFlag()) {
                flagNFCe = x;
                break;
            }
        }
        return flagNFCe;
    }

    @JsonValue
    public int getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}