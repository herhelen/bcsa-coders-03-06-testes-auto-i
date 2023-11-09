package ada.model;

import ada.enums.Size;
import ada.enums.Status;

public class Pizza {

    private String nome;
    private Double preco;
    private Size tamanho;
    private Status status;
    private Boolean pago;

    public Pizza(String nome) {
        this.nome = nome;
        this.preco = 10.0;
        this.status = Status.SOLICITADO;
        this.pago = false;
    }

    public Double escolheTamanho(Size tamanho) {
        this.tamanho = tamanho;
        this.preco = this.preco * this.tamanho.getMultiplicador();
        return this.preco;
    }

    public Status assaPizza() {
        this.status = Status.FAZENDO;
        return this.status;
    }

    public Status pagaPizza() {
        this.pago = true;
        this.status = Status.PRONTO;
        return this.status;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Size getTamanho() {
        return tamanho;
    }

    public Status getStatus() {
        return status;
    }

    public Boolean getPago() {
        return pago;
    }

}
