package objects;

import com.sun.istack.internal.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Music {

    private int id;
    private String title;
    private String artist;
    private LocalDate releaseDate;
    private MusicGenre musicGenre;


    public Music(@NotNull String title, @NotNull String artist, @NotNull LocalDate releaseDate, @NotNull MusicGenre musicGenre) {
        this.title = Objects.requireNonNull(title,"Título não pode ficar em branco.");
        this.artist = Objects.requireNonNull(artist,"Artista não pode ficar em branco.");
        this.releaseDate = Objects.requireNonNull(releaseDate,"Data de lançamento não pode ficar em branco.");
        this.musicGenre = Objects.requireNonNull(musicGenre,"Estilo musical não pode ficar em branco.");
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

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Música[" +
                "id: " + id +
                ", Título: '" + title +
                "', Artista: '" + artist +
                "', Estilo Musical: '" + musicGenre.getDescricao() +
                "', Lançamento: '" + releaseDate.format(formatter) + "']";
    }
}
