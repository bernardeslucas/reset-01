package objects;

public enum GamePlatforms {
    XBOX("Xbox One"),
    PS4("PlayStation 4"),
    PC("PC"),
    SNES("Super NES");

    private final String description;

    public String getDescription() {
        return description;
    }

    GamePlatforms(String description) {
        this.description = description;
    }
}
