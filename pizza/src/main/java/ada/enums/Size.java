package ada.enums;

public enum Size {

    PEQUENO("Pequeno", 1),
    MEDIO("Médio", 2),
    GRANDE("Grande", 3);

    private final String tamanho;
    private final Integer multiplicador;

    Size(String tamanho, Integer multiplicador) {
        this.tamanho = tamanho;
        this.multiplicador = multiplicador;
    }

    public String getTamanho() {
        return tamanho;
    }

    public Integer getMultiplicador() {
        return multiplicador;
    }
}
