package model;

import org.junit.*;

public class CarroTest {


    @Before
    public void before() {
        System.out.println("roda antes de cada teste");
    }

    @After
    public void after() {
        System.out.println("roda após de cada teste");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }


    @Test
    public void deveIniciarDelsigado() {
        // Teste #1 - Deve iniciar desligado
        // Given (Dado): dado um carro
        Carro carro = new Carro();
        // When (Quando): nada
        // Then (Então): o carro deve estar desligado
        Assert.assertFalse(carro.getLigado()); // valor esperado: false
    }

    @Test
    public void deveIniciarComVelocidadeZero() {
        // Teste #2 - Deve iniciar (=instanciar) com velocidade Zero
        // Given (Dado): dado um carro
        Carro carro = new Carro();
        // When (Quando): nada
        // Then (Então): a velocidade do carro deve ser nula
        Assert.assertEquals((Integer) 0, carro.getVelocidadeAtual()); // valor esperado: 0
    }

    @Test
    public void deveLigarCorretamente() {
        // Teste #3 - Deve ligar corretamente
        // Given (Dado): Dado um carro
        Carro carro = new Carro();
        // When (Quando): Quando eu ligar
        carro.ligar();
        // Then (Então): Então o carro deve estar ligado
        Assert.assertTrue(carro.getLigado()); // valor esperado: true
    }

    @Test
    public void deveDelisgarCorretamenteCarroLigado() {
        // Teste #4 - Deve desligar corretamente um carro ligado
        // Given (Dado): dado um carro ligado
        Carro carro = new Carro();
        carro.ligar();
        // When (Quando): quando eu desligar
        carro.desligar();
        // Then (Então): carro deve estar desligado
        Assert.assertFalse(carro.getLigado()); // valor esperado: false
    }

    @Test
    public void deveAcelerarCorretamente() {
        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado): dado um carro
        Carro carro = new Carro();
        // When (Quando): quando eu ligar e acelerar
        carro.ligar();
        carro.acelerar(20);
        // Then (Então): a velocidade deve ser igual velocidade passada na aceleração
        Assert.assertEquals((Integer) 20, carro.getVelocidadeAtual()); // valor esperado: 20
    }

    @Test
    public void naoDeveAcelearCarroDesligado() {
        // Teste #6 - Não deve acelerar um carro desligado
        // Given (Dado): dado um carro desligado
        Carro carro = new Carro();
        // When (Quando): quando acelerar 20
        carro.acelerar(20);
        // Then (Então): a velocidade deve permanecer 0
        Assert.assertEquals((Integer) 0, carro.getVelocidadeAtual()); // valor esperado: 0
    }

    @Test
    public void naoReduzirVelocidadeAbaixoDoZero() {
        // Teste #7 - Não conseguir reduzir a velocidade de um carro ligado, abaixo de 0
        // Given (Dado): dado um carro ligado na velocidade 30
        Carro carro = new Carro();
        carro.ligar();
        carro.acelerar(30);
        // When (Quando): quando frear 40
        carro.frear(40);
        // Then (Então): a velocidade deve tornar nula
        Assert.assertEquals((Integer) 0, carro.getVelocidadeAtual()); // valor esperado: 0
    }
}
