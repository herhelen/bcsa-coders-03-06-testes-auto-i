package ada.enums;

public enum Size {

    PEQUENO("Pequeno", 1.5),
    MEDIO("Médio", 2.0),
    GRANDE("Grande", 3.05);

    private final String tamanho;
    private final Double multiplicador;

    Size(String tamanho, Double multiplicador) {
        this.tamanho = tamanho;
        this.multiplicador = multiplicador;
    }

    public String getTamanho() {
        return tamanho;
    }

    public Double getMultiplicador() {
        return multiplicador;
    }
}
