package br.com.cwi.tinderevolution.domain.movie;

import br.com.cwi.tinderevolution.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {

    private int id;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private MovieGenres movieGenre;
    private String storyline;
    private final List<User> users = new ArrayList<>();

    public Movie(String title, String director, LocalDate releaseDate, MovieGenres movieGenre, String storyline) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.movieGenre = movieGenre;
        this.storyline = storyline;
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

    public MovieGenres getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenres movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
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
        return "Filme [" +
                "id: '" + id +
                "', Título: '" + title +
                "', Diretor: '" + director +
                "', Data de lançamento: '" + releaseDate +
                "', Categoria: '" + movieGenre.getDescription() +
                "', Sinopse: '" + storyline + "']";
    }
}
