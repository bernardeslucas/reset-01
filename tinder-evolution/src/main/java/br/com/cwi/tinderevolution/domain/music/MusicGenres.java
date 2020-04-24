package br.com.cwi.tinderevolution.domain.music;

public enum MusicGenres {
    FUNK("Funk"),
    INDIE("Indie"),
    METAL("Metal"),
    PAGODE("Pagode"),
    ROCK("Rock"),
    SERTANEJO("Sertanejo");

    private final String description;

    MusicGenres(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
