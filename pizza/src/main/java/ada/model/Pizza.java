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
        this.pago = false;
    }

    public Double escolheTamanho(Size tamanho) {
        this.status = Status.PEDIDO;
        this.tamanho = tamanho;
        this.preco = this.preco * this.tamanho.getMultiplicador();
        return this.preco;
    }

    public Status assaPizza() {
        if(this.status == Status.PEDIDO) {
            this.status = Status.FAZENDO;
        }
        return this.status;
    }

    public Status pagaPizza() {
        if(this.status == Status.FAZENDO) {
            this.pago = true;
            this.status = Status.PRONTO;
        }
        return this.status;
    }

    public Status entregaPizza() {
        if(!this.pago) {
            throw new RuntimeException("A pizza ainda não foi paga!");
        }

        this.status = Status.ENTREGUE;
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
