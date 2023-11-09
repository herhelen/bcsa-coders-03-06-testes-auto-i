package ada.enums;

public enum Status {

    PEDIDO("pedido"),
    FAZENDO("fazendo"),
    PRONTO("pronto"),
    ENTREGUE("entregue");

    private final String estado;

    Status(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
