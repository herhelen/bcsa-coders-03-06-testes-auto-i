package com.ada.banco.domain.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import static org.junit.jupiter.api.Assertions.*;

import com.ada.banco.dummy.ContaGatewayDummyImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TransferirEntreDuasContasDentroBancoTest {

    @Test
    public void naoDeveTransferirEntreContasInexistetes() {
        // given
        Conta origemInexistente = new Conta(3333L, 6666L, 7L, BigDecimal.valueOf(1500.0),
                "Origem Inexistente", "01122233344");
        Conta destino = new Conta(4444L, 5555L, 4L, BigDecimal.ZERO,
                "Destino", "55566677788");
        ContaGateway contaGateway = new ContaGatewayDummyImpl();
        TransferirEntreContasDentroBanco transferirEntreContasDentroBanco =
                new TransferirEntreContasDentroBanco(contaGateway);

        // when & then
        Throwable throwable = assertThrows(Exception.class,
                () -> transferirEntreContasDentroBanco.execute(origemInexistente, destino, BigDecimal.valueOf(450.0)));
        assertEquals("A conta remetente e/ou a conta destino não existe.", throwable.getMessage());
    }

    @Test
    public void deveTransferirEntreDuasContasComSucesso() throws Exception {
        // given
        Conta origem = new Conta(1111L, 2222L, 1L, BigDecimal.valueOf(1000.0),
                "Origem", "11122233344");
        Conta destino = new Conta(4444L, 5555L, 4L, BigDecimal.ZERO,
                "Destino", "55566677788");
        ContaGateway contaGateway = new ContaGatewayDummyImpl();
        TransferirEntreContasDentroBanco transferirEntreContasDentroBanco =
                new TransferirEntreContasDentroBanco(contaGateway);

        // when & then
        Conta origemPosTransferencia =
                transferirEntreContasDentroBanco.execute(origem, destino, BigDecimal.valueOf(350.99));

        assertAll(
                () -> assertEquals(BigDecimal.valueOf(649.01), origemPosTransferencia.getSaldo()),
                () -> assertEquals(BigDecimal.valueOf(350.99), destino.getSaldo()),
                () -> assertSame(origem, origemPosTransferencia)
        );
    }

    @Test
    public void naoDeveFazerTransferenciaComValorNegativo() {
        // given
        Conta origem = new Conta(1111L, 2222L, 1L, BigDecimal.valueOf(1000.0),
                "Origem", "11122233344");
        Conta destino = new Conta(4444L, 5555L, 4L, BigDecimal.ZERO,
                "Destino", "55566677788");
        ContaGateway contaGateway = new ContaGatewayDummyImpl();
        TransferirEntreContasDentroBanco transferirEntreContasDentroBanco =
                new TransferirEntreContasDentroBanco(contaGateway);

        // when & then
        Throwable throwable = assertThrows(Exception.class,
                () -> transferirEntreContasDentroBanco.execute(origem, destino, BigDecimal.valueOf(-50.0)));
        assertEquals("O valor a ser transferido deve ser maior que zero.", throwable.getMessage());

    }

}
