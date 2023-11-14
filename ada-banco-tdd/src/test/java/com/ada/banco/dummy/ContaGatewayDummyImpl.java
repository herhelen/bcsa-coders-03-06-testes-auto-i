package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class ContaGatewayDummyImpl implements ContaGateway {

    @Override
    public Conta buscarPorCpf(String cpf) {
        if("11133355500".equals(cpf)) {
            return new Conta(2222L, 2L, 1L, BigDecimal.ZERO, "Paula", "11133355500");
        } else {
            return null;
        }
    }

    @Override
    public Conta salvar(Conta conta) {
        return new Conta(3333L, 2L, 1L, BigDecimal.ZERO, "Elsa", "22211155500");
    }
}

