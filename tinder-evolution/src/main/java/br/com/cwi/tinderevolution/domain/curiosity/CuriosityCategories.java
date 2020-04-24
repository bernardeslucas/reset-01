package br.com.cwi.tinderevolution.domain.curiosity;

public enum CuriosityCategories {
    APPEARANCE("Aparência"),
    BEHAVIOUR("Comportamento"),
    EATING("Alimentação"),
    EVENT("Evento");

    private final String description;

    CuriosityCategories(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
