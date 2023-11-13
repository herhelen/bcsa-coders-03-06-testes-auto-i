package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

    private Carro carro;
    private final String MARCA = "toyota";
    private final String MODELO = "corolla";
    private final String COR = "prata";
    private final Integer VELOCIDADE_MAXIMA = 250;

    @BeforeEach
    public void instanciarCarro() {
        this.carro = new Carro(this.MARCA, this.MODELO, this.COR, this.VELOCIDADE_MAXIMA);
    }

    @Test
    public void deveCriarUmCarroComOsAtributosCorretamenteInicializados() {

        assertAll(
                () -> assertEquals(this.MARCA, this.carro.getMarca()),
                () -> assertEquals(this.MODELO, this.carro.getModelo()),
                () -> assertEquals(this.COR, this.carro.getCor()),
                () -> assertEquals(this.VELOCIDADE_MAXIMA, this.carro.getVelocidadeMaxima()),
                () -> assertFalse(this.carro.getLigado()),
                () -> assertEquals(0, this.carro.getVelocidadeAtual())
        );
    }

    @Test
    public void deveLigarUmCarroCorretamente() {
        this.carro.ligar();

        assertTrue(this.carro.getLigado());
    }

    @Test
    public void deveAcelerarUmCarroLigadoCorretamente() {
        this.carro.ligar();

        this.carro.acelerar(103);

        assertEquals(103, this.carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveAcelerarUmCarroDesligado() {
        this.carro.acelerar(103);

        assertEquals(0, this.carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveAcelearUmCarroLigadoNegativamente() {
        this.carro.ligar();

        this.carro.acelerar(10);
        this.carro.acelerar( -5);

        assertEquals(10, this.carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveUltrapassarVelociadeMaximaAoAcelerarUmCarroLigado() {
        this.carro.ligar();

        this.carro.acelerar(this.VELOCIDADE_MAXIMA);
        this.carro.acelerar(5000);

        assertEquals(this.VELOCIDADE_MAXIMA, this.carro.getVelocidadeAtual());
    }

    @Test
    public void deveFrearUmCarroLigadoCorretamente() {
        this.carro.ligar();

        this.carro.acelerar(103);

        this.carro.frear(100);

        assertEquals(3, this.carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveFrearUmCarroDesligado() {
        this.carro.frear(103);

        assertEquals(0, this.carro.getVelocidadeAtual());
    }
}