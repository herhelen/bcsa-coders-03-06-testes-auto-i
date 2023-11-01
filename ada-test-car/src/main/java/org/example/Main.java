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
        // Given (Dado): dado um carro ligado
        // When (Quando): quando eu desligar
        // Then (Então): carro deve estar desligado

        // Teste #5 - Deve acelerar corretamente um carro ligado
        // Given (Dado): dado um carro
        // When (Quando): quando eu ligar e acelerar
        // Then (Então): a velocidade deve ser

        // Teste #6 - Não deve acelerar um carro desligado
        // Given (Dado)
        // When (Quando)
        // Then (Então)

        // Teste #7 - Não conseguir reduzir a velocidade de um carro ligado, abaixo de 0
        // Given (Dado)
        // When (Quando)
        // Then (Então)
    }
}