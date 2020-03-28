package storage;

import objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieStorage {

    private static final List<Movie> movies = new ArrayList<>();
    private static int contadorId = 1;

    public Movie create(Movie movie) {
        movie.setId(contadorId++);
        movies.add(movie);
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
