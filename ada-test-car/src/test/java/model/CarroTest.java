package model;

import org.example.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroTest {

    @Test
    public void deveIniciarDelsigado() {
        // Teste #1 - Deve iniciar desligado
        // Given (Dado): dado um carro
        Carro carro1 = new Carro();
        // When (Quando): nada
        // Then (Então): o carro deve estar desligado
        Assert.assertFalse(carro1.getLigado()); // valor esperado: false
    }

    @Test
    public void deveIniciarComVelocidadeZero() {
        // Teste #2 - Deve iniciar (=instanciar) com velocidade Zero
        // Given (Dado): dado um carro
        Carro carro2 = new Carro();
        // When (Quando): nada
        // Then (Então): a velocidade do carro deve ser nula
        Assert.assertEquals((Integer) 0, carro2.getVelocidadeAtual()); // valor esperado: 0
    }

    @Test
    public void deveLigarCorretamente() {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado): Dado um carro
        Carro carro3 = new Carro();
        // When (Quando): Quando eu ligar
        carro3.ligar();
        // Then (Então): Então o carro deve estar ligado
        Assert.assertTrue(carro3.getLigado()); // valor esperado: true
    }

    @Test
    public void deveDelisgarCorretamenteCarroLigado() {
        // Teste #4 - Deve desligar corretamente um carro ligado
        // Given (Dado): dado um carro ligado
        Carro carro4 = new Carro();
        carro4.ligar();
        // When (Quando): quando eu desligar
        carro4.desligar();
        // Then (Então): carro deve estar desligado
        Assert.assertFalse(carro4.getLigado()); // valor esperado: false
    }

    @Test
    public void deveAcelerarCorretamente() {
        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado): dado um carro
        Carro carro5 = new Carro();
        // When (Quando): quando eu ligar e acelerar
        carro5.ligar();
        carro5.acelerar(20);
        // Then (Então): a velocidade deve ser igual velocidade passada na aceleração
        Assert.assertEquals((Integer) 20, carro5.getVelocidadeAtual()); // valor esperado: 20
    }

    @Test
    public void naoDeveAcelearCarroDesligado() {
        // Teste #6 - Não deve acelerar um carro desligado
        // Given (Dado): dado um carro desligado
        Carro carro6 = new Carro();
        // When (Quando): quando acelerar 20
        carro6.acelerar(20);
        // Then (Então): a velocidade deve permanecer 0
        Assert.assertEquals((Integer) 0, carro6.getVelocidadeAtual()); // valor esperado: 0
    }

    @Test
    public void naoReduzirVelocidadeAbaixoDoZero() {
        // Teste #7 - Não conseguir reduzir a velocidade de um carro ligado, abaixo de 0
        // Given (Dado): dado um carro ligado na velocidade 30
        Carro carro7 = new Carro();
        carro7.ligar();
        carro7.acelerar(30);
        // When (Quando): quando frear 40
        carro7.frear(40);
        // Then (Então): a velocidade deve tornar nula
        Assert.assertEquals((Integer) 0, carro7.getVelocidadeAtual()); // valor esperado: 0
    }
}
