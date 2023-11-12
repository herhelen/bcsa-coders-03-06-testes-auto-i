package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarroTest {

    @Test
    public void deveCriarUmCarroComOsAtributosCorretamenteInicializados() {

        Carro carro = new Carro("toyota", "corolla", "prata", 250);

        assertAll(
                () -> assertEquals("toyota", carro.getMarca()),
                () -> assertEquals("corolla", carro.getModelo()),
                () -> assertEquals("prata", carro.getCor()),
                () -> assertEquals(250, carro.getVelocidadeMaxima()),
                () -> assertFalse(carro.getLigado()),
                () -> assertEquals(0, carro.getVelocidadeAtual())
        );

    }


}