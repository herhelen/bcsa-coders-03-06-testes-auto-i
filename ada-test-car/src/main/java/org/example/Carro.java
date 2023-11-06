package org.example;

public class Carro {

    private String cor;
    private String marca;
    private String modelo;
    private Boolean ligado;
    private Integer velocidadeAtual;
    private Integer velocidadeMaxima;

    public Carro() {
        this.ligado = false;
        this.velocidadeAtual = 0;
        this.velocidadeMaxima = 200;
    }

    public Carro(Integer velocidadeMaxima) {
        this.velocidadeAtual = 0;
        this.ligado = false;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    public void acelerar(Integer velocidade) {
        if(this.ligado) {
            if(this.velocidadeMaxima <= velocidade + velocidadeAtual) {
                this.velocidadeAtual = this.velocidadeMaxima;
            } else {
                this.velocidadeAtual = velocidade + velocidadeAtual;
            }
        }
    }

    public void frear(Integer velocidade) {
        if(velocidade <= this.velocidadeAtual) {
            this.velocidadeAtual -= velocidade;
        } else {
            this.velocidadeAtual = 0;
        }
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public Integer getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(Integer velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
