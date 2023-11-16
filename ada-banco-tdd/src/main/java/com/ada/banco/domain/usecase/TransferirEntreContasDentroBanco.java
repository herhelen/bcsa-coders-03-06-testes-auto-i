package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class TransferirEntreContasDentroBanco {

    public Conta execute(Conta origem, Conta destino, BigDecimal valorASerTransferido) {

        return origem;
    }
}
