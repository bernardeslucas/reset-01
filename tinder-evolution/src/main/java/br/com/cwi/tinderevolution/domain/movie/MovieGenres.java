package br.com.cwi.tinderevolution.domain.movie;

public enum MovieGenres {
    ACTION("Ação"),
    COMEDY("Comédia"),
    DRAMA("Drama"),
    HORROR("Terror"),
    MUSICAL("Musical"),
    SUSPENSE("Suspense");

    MovieGenres(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }
}
