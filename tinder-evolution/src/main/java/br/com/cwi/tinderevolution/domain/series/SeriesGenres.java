package br.com.cwi.tinderevolution.domain.series;

public enum SeriesGenres {
    ACTION("Ação"),
    DRAMA("Drama"),
    COMEDY("Comédia"),
    HORROR("Terror"),
    SITCOM("Sitcom"),
    SUSPENSE("Suspense");

    private final String description;

    SeriesGenres(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
