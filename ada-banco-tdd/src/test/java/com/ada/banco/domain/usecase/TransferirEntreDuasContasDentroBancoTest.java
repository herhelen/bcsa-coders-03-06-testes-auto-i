package com.ada.banco.domain.usecase;

import com.ada.banco.domain.model.Conta;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TransferirEntreDuasContasDentroBancoTest {

    @Test
    public void deveTransferirEntreDuasContasComSucesso() {
        Conta origem = new Conta(1111L, 2222L, 1L, BigDecimal.valueOf(1000.0), "Origem", "11122233344");
        Conta destino = new Conta(4444L, 5555L, 4L, BigDecimal.ZERO, "Destino", "55566677788");

        TransferirEntreContasDentroBanco transferirEntreContasDentroBanco = new TransferirEntreContasDentroBanco();
        Conta origemPosTransferencia = transferirEntreContasDentroBanco.execute(origem, destino, BigDecimal.valueOf(350.99));

        assertAll(
                () -> assertEquals(BigDecimal.valueOf(649.01), origemPosTransferencia.getSaldo()),
                () -> assertEquals(BigDecimal.valueOf(350.99), destino.getSaldo()),
                () -> assertSame(origem, origemPosTransferencia)
        );


    }

}
