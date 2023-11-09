package ada.enums;

public enum Status {

    SOLICITADO("solicitado"),
    FAZENDO("fazendo"),
    PRONTO("pronto");

    private final String estado;

    Status(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
