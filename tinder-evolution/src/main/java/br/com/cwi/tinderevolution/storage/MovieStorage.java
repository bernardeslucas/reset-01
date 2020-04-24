package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static br.com.cwi.tinderevolution.domain.user.UserDTO.transformList;

@Repository
public class MovieStorage {

    private static final List<Movie> movies = new ArrayList<>();

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
        movieToEdit.setStoryline(movieUpdated.getStoryline());

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

    public boolean delete(Movie movieToDelete) {
        movies.remove(movieToDelete);
        return true;
    }

    public List<UserDTO> getUsers(Movie movie) {
        return transformList(movie.getUsers());
    }

}
