package objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Music {

    private int id;
    private String title;
    private String artist;
    private LocalDate releaseDate;
    private MusicGenres musicGenre;


    public Music(String title, String artist, LocalDate releaseDate, MusicGenres musicGenre) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.musicGenre = musicGenre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MusicGenres getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenres musicGenre) {
        this.musicGenre = musicGenre;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Música [" +
                "id: '" + id +
                "', Título: '" + title +
                "', Artista: '" + artist +
                "', Estilo Musical: '" + musicGenre.getDescricao() +
                "', Lançamento: '" + releaseDate.format(formatter) + "']";
    }
}
