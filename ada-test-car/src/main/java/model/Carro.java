package model;


public class Carro {

    private String cor;
    private String marca;
    private String modelo;
    private Boolean ligado;
    private Integer velocidadeAtual;
    private Integer velocidadeMaxima;

    public Carro(String marca, String modelo, String cor, Integer velocidadeMaxima) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;

        this.ligado = false;
        this.velocidadeAtual = 0;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {

    }

    public void acelerar(Integer acrescimoVeocidade) {
        // Só podemos realizar as ações como acelerar e frear com o carro ligado
        // Não existe velocidade negativa => tratar entrada
        // O carro não pode passar de sua velocidade máxima

        if(this.ligado) {
            if(acrescimoVeocidade > 0) {
                if(this.velocidadeAtual + acrescimoVeocidade <= this.velocidadeMaxima) {
                    this.velocidadeAtual += acrescimoVeocidade;
                } else {
                    this.velocidadeAtual = this.velocidadeMaxima;

                    System.out.println("WARN: O carro já atigiu a sua velocidade máxima.");
                }
            } else {
                System.out.println("WARN: Deve apenas acelerar com acréscimo de velocidade maior que zero (valor positivo)");
            }
        }
    }

    public void frear() {

    }

    public String getCor() {
        return this.cor;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Boolean getLigado() {
        return this.ligado;
    }

    public Integer getVelocidadeAtual() {
        return this.velocidadeAtual;
    }

    public Integer getVelocidadeMaxima() {
        return this.velocidadeMaxima;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "cor='" + this.cor + '\'' +
                ", marca='" + this.marca + '\'' +
                ", modelo='" + this.modelo + '\'' +
                ", ligado=" + this.ligado +
                ", velocidadeAtual=" + this.velocidadeAtual +
                ", velocidadeMaxima=" + this.velocidadeMaxima +
                '}';
    }
}
