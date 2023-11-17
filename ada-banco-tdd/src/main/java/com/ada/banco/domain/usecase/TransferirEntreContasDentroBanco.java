package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class TransferirEntreContasDentroBanco {

    private ContaGateway contaGateway;

    public TransferirEntreContasDentroBanco(ContaGateway contaGateway) {
        this.contaGateway = contaGateway;
    }

    public Conta execute(Conta origem, Conta destino, BigDecimal valorASerTransferido) throws Exception {

        if(valorASerTransferido.compareTo(BigDecimal.ZERO) < 1) { // -1: <, 0: =, 1: >
            throw new Exception("O valor a ser transferido deve ser maior que zero.");
        }

        if((this.contaGateway.buscarPorCpf(origem.getCpf()) != null) &&
           (this.contaGateway.buscarPorCpf(destino.getCpf()) != null)) {

            origem.setSaldo(origem.getSaldo().subtract(valorASerTransferido));
            destino.setSaldo(destino.getSaldo().add(valorASerTransferido));
        } else {
            throw new Exception("A conta remetente e/ou a conta destino não existe.");
        }

        return origem;
    }
}
