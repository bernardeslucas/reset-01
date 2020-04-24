package br.com.cwi.tinderevolution.domain.game;

public enum GamePlatforms {
    PC("PC"),
    PS4("PlayStation 4"),
    SNES("Super NES"),
    XBOX("Xbox One");

    private final String description;

    GamePlatforms(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
