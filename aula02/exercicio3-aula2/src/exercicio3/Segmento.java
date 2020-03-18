package exercicio3;

public enum Segmento {
    ALIMENTACAO("[Alimentação]"),
    LIMPEZA("[Limpeza]"),
    HIGIENE("[Higiene]");

    private final String descricao;

    Segmento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
