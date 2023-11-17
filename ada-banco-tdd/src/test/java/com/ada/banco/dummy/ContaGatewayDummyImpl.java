package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class ContaGatewayDummyImpl implements ContaGateway {

    @Override
    public Conta buscarPorCpf(String cpf) {
        if("11133355500".equals(cpf)) {
            return new Conta(2222L, 2L, 1L, BigDecimal.ZERO, "Paula", "11133355500");
        } else if("11122233344".equals(cpf)) {
            return new Conta(1111L, 2222L, 1L, BigDecimal.valueOf(1000.0),
                    "Origem", "11122233344");
        } else if("55566677788".equals(cpf)) {
            return new Conta(4444L, 5555L, 4L, BigDecimal.ZERO, "Destino", "55566677788");
        } else {
            return null;
        }
    }

    @Override
    public Conta salvar(Conta conta) {
        return new Conta(3333L, 2L, 1L, BigDecimal.ZERO, "Elsa", "22211155500");
    }
}

