package objects;

public enum MovieGenres {
    DRAMA("Drama"),
    COMEDIA("Comédia"),
    SUSPENSE("Suspense"),
    TERROR("Terror"),
    ACAO("Ação"),
    MUSICAL("Musical");

    MovieGenres(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }
}
