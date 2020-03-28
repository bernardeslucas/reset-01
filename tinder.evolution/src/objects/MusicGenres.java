package objects;

public enum MusicGenres {
    FUNK("Funk"),
    INDIE("Indie"),
    METAL("Metal"),
    PAGODE("Pagode"),
    ROCK("Rock"),
    SERTANEJO("Sertanejo");


    private final String descricao;

    MusicGenres(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
