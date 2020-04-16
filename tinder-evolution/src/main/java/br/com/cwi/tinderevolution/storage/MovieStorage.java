package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.movie.Movie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieStorage {

    private static final List<Movie> movies = new ArrayList<>();
    private static int contadorId = 1;

    public Movie create(Movie movie) {

        movies.add(movie);
        movies.sort(Comparator.comparingInt(Movie::getId));
        return movie;
    }

    public Movie edit(Movie movieToEdit, Movie movieUpdated) {
        movieToEdit.setTitle(movieUpdated.getTitle());
        movieToEdit.setDirector(movieUpdated.getDirector());
        movieToEdit.setTitle(movieUpdated.getTitle());
        movieToEdit.setReleaseDate(movieUpdated.getReleaseDate());
        movieToEdit.setMovieGenre(movieUpdated.getMovieGenre());
        movieToEdit.setStoryLine(movieUpdated.getStoryLine());

        return movieToEdit;
    }

    public List<Movie> list() {
        return movies;
    }

    public Movie search(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Movie movieToDelete = search(id);
        if (movieToDelete != null) {
            return movies.remove(movieToDelete);
        }
        return false;


    }


}
