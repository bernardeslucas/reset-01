package objects;

public enum MusicGenre {
    FUNK("Funk"),
    INDIE("Indie"),
    METAL("Metal"),
    PAGODE("Pagode"),
    ROCK("Rock"),
    SERTANEJO("Sertanejo");


    private final String descricao;

    MusicGenre(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
