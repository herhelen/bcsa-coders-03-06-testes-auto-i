package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.dummy.ContaGatewayDummyImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CriarNovaContaTest {

    @Test
    public void deveLancarUmaExceptionCasoUsuarioJaTemUmaConta() {
        // given
        ContaGateway contaGateway = new ContaGatewayDummyImpl(); // Responsável por verificar se existe uma conta
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(2222L, 2L, 1L, BigDecimal.ZERO, "Paula", "11133355500");

        // when & then
        assertThrows(Exception.class,
                () -> criarNovaConta.execute(conta));
    }

    @Test
    public void deveCriarUmaContaNovaComSucesso() throws Exception {
        // given
        ContaGateway contaGateway = new ContaGatewayDummyImpl(); // Responsável por verificar se existe uma conta
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(3333L, 2L, 1L, BigDecimal.ZERO, "Elsa", "22211155500");

        // when & then
        Conta novaConta = criarNovaConta.execute(conta);
        assertEquals(conta, novaConta);
    }
}
