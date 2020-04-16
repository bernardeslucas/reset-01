package br.com.cwi.tinderevolution.domain.series;

public enum SeriesGenres {
    DRAMA("Drama"),
    COMEDY("Comédia"),
    SUSPENSE("Suspense"),
    HORROR("Terror"),
    ACTION("Ação"),
    SITCOM("Sitcom");

    private final String description
            ;

    public String getDescription() {
        return description
                ;
    }

    SeriesGenres(String description
    ) {
        this.description
                = description
        ;
    }
}
