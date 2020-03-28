package objects;

public enum GameGenres {
    DRAMA("Drama"),
    COMEDY("Comédia"),
    SUSPENSE("Suspense"),
    HORROR("Terror"),
    ACTION("Ação"),
    MUSICAL("Musical");

    private final String description;

    public String getDescription() {
        return description;
    }

    GameGenres(String description) {
        this.description = description;
    }
}
