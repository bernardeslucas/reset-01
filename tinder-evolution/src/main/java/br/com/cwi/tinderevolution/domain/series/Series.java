package br.com.cwi.tinderevolution.domain.series;

import br.com.cwi.tinderevolution.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Series {

    private int id;
    private String name;
    private String director;
    private LocalDate releaseDate;
    private int seasonQty;
    private int episodesQty;
    private SeriesGenres seriesGenre;
    private String storyLine;
    private List<User> users = new ArrayList<>();

    public Series(String name, String director, LocalDate releaseDate, int seasonQty, int episodesQty, SeriesGenres seriesGenre, String storyLine) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
        this.seasonQty = seasonQty;
        this.episodesQty = episodesQty;
        this.seriesGenre = seriesGenre;
        this.storyLine = storyLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getSeasonQty() {
        return seasonQty;
    }

    public void setSeasonQty(int seasonQty) {
        this.seasonQty = seasonQty;
    }

    public int getEpisodesQty() {
        return episodesQty;
    }

    public void setEpisodesQty(int episodesQty) {
        this.episodesQty = episodesQty;
    }

    public SeriesGenres getSeriesGenre() {
        return seriesGenre;
    }

    public void setSeriesGenre(SeriesGenres seriesGenre) {
        this.seriesGenre = seriesGenre;
    }

    public String getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public String toString() {
        return "Série [" +
                "id: '" + id +
                "', Nome: '" + name +
                "', Diretor: " + director +
                "', Data de lançamento: '" + releaseDate +
                "',Temporadas: '" + seasonQty +
                "',Episódios: '" + episodesQty +
                "', Categoria: '" + seriesGenre.getDescription() +
                "', Sinopse: '" + storyLine+"']";
    }
}
