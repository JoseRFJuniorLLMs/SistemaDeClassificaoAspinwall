package com.booksgames.loja.documents.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FlagPgto {

    DINHEIRO(1), CHEQUE(2), CARTAO(3), FINANCIADO(4), TROCO(5), VALECREDITO(6), VALEALIMENTACAO(10), VALEREFEICAO(11),
    VALEPRESENTE(12), VALECOMBUSTIVEL(13), OUTROSIS(99);

    private int flag;

    FlagPgto(int flag) {
        this.flag = flag;
    }

    @JsonCreator
    public static FlagPgto parse(int flag) {
        if (flag == 0) {
            return null;
        }
        FlagPgto flagPgto = null;

        for (FlagPgto x : FlagPgto.values()) {
            if (flag == x.getFlag()) {
                flagPgto = x;
                break;
            }
        }
        return flagPgto;
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