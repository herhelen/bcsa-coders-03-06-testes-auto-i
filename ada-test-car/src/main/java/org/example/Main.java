package org.example;

public class Main {
    /*
    *  Enquanto o carro estiver desligado deve ser capaz de:
    *  - Ligar
    *  - Mostrar estado atual (toString())

    * Enquanto o carro estiver ligado deve ser capaz de:
     * - Desligar
     * - Acelerar
     * - Frear
     * - Motrar estado atual

    * Regras:
     * - Só podemos realizar as ações como acelerar e frear com o carro ligado
     * - Só podemos desligar o carro quando ele parar totalmente (velocidadeAtual = 0)
     * - Não existe velocidade negativa
     * - O carro não pode passar de sua velocidade máxima
    */

    public static void main(String[] args) {

        // Gherkin
        // Given (Dado)
        // When (Quando)
        // Then (Então)

        // Teste #1 - Deve iniciar desligado
        System.out.println("Teste #1 - Deve iniciar desligado");
        // Given (Dado): dado um carro
        Carro carro1 = new Carro();
        // When (Quando): nada
        // Then (Então): o carro deve estar desligado
        System.out.println(!carro1.getLigado()); // valor esperado: false
        System.out.println("----------------------------------");

        // Teste #2 - Deve iniciar (=instanciar) com velocidade Zero
        System.out.println("Teste #2 - Deve iniciar com velocidade Zero");
        // Given (Dado): dado um carro
        Carro carro2 = new Carro();
        // When (Quando): nada
        // Then (Então): a velocidade do carro deve ser nula
        System.out.println(carro2.getVelocidadeAtual() == 0); // valor esperado: 0
        System.out.println("----------------------------------");

        // Teste #3 - Deve ligar corretamente
        System.out.println("Teste #3 - Deve ligar corretamente");
        // Given (Dado): Dado um carro
        Carro carro3 = new Carro();
        // When (Quando): Quando eu ligar
        carro3.ligar();
        // Then (Então): Então o carro deve estar ligado
        System.out.println(carro3.getLigado()); // valor esperado: true
        System.out.println("----------------------------------");

        // Teste #4 - Deve desligar corretamente um carro ligado
        System.out.println("Teste #4 - Deve desligar corretamente um carro ligado");
        // Given (Dado): dado um carro ligado
        Carro carro4 = new Carro();
        carro4.ligar();
        // When (Quando): quando eu desligar
        carro4.desligar();
        // Then (Então): carro deve estar desligado
        System.out.println(!carro4.getLigado()); // valor esperado: false
        System.out.println("----------------------------------");

        // Teste #5 - Deve acelerar corretamente um carro ligado
        System.out.println("Teste #5 - Deve acelerar corretamente um carro ligado");
        // Given (Dado): dado um carro
        Carro carro5 = new Carro();
        // When (Quando): quando eu ligar e acelerar
        carro5.ligar();
        carro5.acelerar(20);
        // Then (Então): a velocidade deve ser igual velocidade passada na aceleração
        System.out.println(carro5.getVelocidadeAtual() == 20); // valor esperado: 20
        System.out.println("----------------------------------");

        // Teste #6 - Não deve acelerar um carro desligado
        System.out.println("Teste #6 - Não deve acelerar um carro desligado");
        // Given (Dado): dado um carro desligado
        Carro carro6 = new Carro();
        // When (Quando): quando acelerar 20
        carro6.acelerar(20);
        // Then (Então): a velocidade deve permanecer 0
        System.out.println(carro6.getVelocidadeAtual() == 0); // valor esperado: 0
        System.out.println("----------------------------------");

        // Teste #7 - Não conseguir reduzir a velocidade de um carro ligado, abaixo de 0
        System.out.println("Teste #7 - Não conseguir reduzir a velocidade de um carro ligado, abaixo de 0");
        // Given (Dado): dado um carro ligado na velocidade 30
        Carro carro7 = new Carro();
        carro7.ligar();
        carro7.acelerar(30);
        // When (Quando): quando frear 40
        carro7.frear(40);
        // Then (Então): a velocidade deve tornar nula
        System.out.println(carro7.getVelocidadeAtual() == 0);
        System.out.println("----------------------------------");

    }
}