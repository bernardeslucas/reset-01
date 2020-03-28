package objects;

public enum CuriosityCategories {
    ALIMENTACAO("Alimentação"),
    APARENCIA("Aparência"),
    COMPORTAMENTO("Comportamento"),
    EVENTO("Evento");



    private final String description;

    public String getDescription() {
        return description;
    }

    CuriosityCategories(String description) {
        this.description = description;
    }
}
