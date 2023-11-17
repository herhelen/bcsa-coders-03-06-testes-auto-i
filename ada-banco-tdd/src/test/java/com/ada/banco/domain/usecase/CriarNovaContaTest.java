package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CriarNovaContaTest {

    @Test
    public void deveCriarUmaContaNovaComSucesso() throws Exception {
        // given
        ContaGateway contaGateway = mock(ContaGateway.class);
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(3333L, 2L, 1L, BigDecimal.ZERO, "Elsa", "22211155500");

        // when & then
        when(contaGateway.buscarPorCpf(conta.getCpf())).thenReturn(null);
        when(contaGateway.salvar(conta)).thenReturn(conta);

        Conta novaConta = criarNovaConta.execute(conta);
        assertEquals(conta, novaConta);

        verify(contaGateway, times(1)).buscarPorCpf(conta.getCpf());
        verify(contaGateway, times(1)).salvar(conta);
    }

    @Test
    public void deveLancarUmaExceptionCasoUsuarioJaTemUmaConta() {
        // given
        ContaGateway contaGateway = mock(ContaGateway.class);
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);
        Conta conta = new Conta(2222L, 2L, 1L, BigDecimal.ZERO, "Paula", "11133355500");

        // when & then
        when(contaGateway.buscarPorCpf(conta.getCpf())).thenReturn(conta);
        assertThrows(Exception.class,
                () -> criarNovaConta.execute(conta));

        verify(contaGateway, times(1)).buscarPorCpf(conta.getCpf());
        verify(contaGateway, never()).salvar(conta);
    }
}
