package br.com.cwi.tinderevolution.domain.movie;

import java.time.LocalDate;

public class Movie {

private int id;
private String title;
private String director;
private LocalDate releaseDate;
private MovieGenres movieGenre;
private String storyLine;


    public Movie(String title, String director, LocalDate releaseDate, MovieGenres movieGenre, String storyLine) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.movieGenre = movieGenre;
        this.storyLine = storyLine;
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

    public String getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

    @Override
    public String toString() {
        return "Filme ["+
                "id: '"+id+
                "', Título: '"+title+
                "', Diretor: '"+director+
                "', Data de lançamento: '"+releaseDate+
                "', Categoria: '"+movieGenre.getDescription()+
                "', Sinopse: '"+storyLine+"']";
    }
}
