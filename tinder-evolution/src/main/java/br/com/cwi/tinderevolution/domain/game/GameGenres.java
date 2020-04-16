package br.com.cwi.tinderevolution.domain.game;

public enum GameGenres {
    ACTION("Ação"),
    FIGHT("Luta"),
    HORROR("Terror"),
    RPG("Rpg"),
    SANDBOX("Sandbox"),
    SPORTS("Esportes");

    private final String description;

    GameGenres(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
