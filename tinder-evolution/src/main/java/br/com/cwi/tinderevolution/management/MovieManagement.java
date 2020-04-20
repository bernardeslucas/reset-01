package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.MovieStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieManagement {

    private MovieStorage storage = new MovieStorage();

    public boolean checkExistent(Movie movie) {
        List<Movie> movies = storage.list();
        for (Movie movieExistent : movies) {
            if (movie.getTitle().equals(movieExistent.getTitle())) {
                System.out.println("Filme já cadastrado.");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(Movie movie) {

        if (movie.getTitle().isEmpty() || movie.getDirector().isEmpty() || movie.getReleaseDate() == null || movie.getMovieGenre() == null || movie.getStoryLine().isEmpty()) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        if (movie.getReleaseDate().isAfter(LocalDate.now())) {
            System.out.println("Data de lançamento futura.");
            return true;
        }

        return false;
    }

    public int checkId() {
        //to always get the lowest number(id) available

        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getId() != (i + 1)) {
                return i + 1;
            }
        }
        return storage.list().size() + 1;
    }

    public Movie checkMovie(int id) {
        Movie movie = search(id);
        if (movie == null) {
            throw new RuntimeException("Filme não encontrado.");
        }
        return movie;
    }

    public Movie create(Movie movie) {

        if (checkExistent(movie) || checkError(movie)) {
            return null;
        }
        movie.setId(checkId());

        return storage.create(movie);
    }

    public List<Movie> list() {
        return storage.list();
    }

    public Movie edit(int id, Movie movieUpdated) {
        Movie movieToEdit = checkMovie(id);

        if (!movieToEdit.getTitle().equals(movieUpdated.getTitle())) {
            if (checkExistent(movieUpdated)) {
                return null;
            }
        }
        if (checkError(movieUpdated)) {
            return null;
        }
        return storage.edit(movieToEdit, movieUpdated);
    }

    public Movie search(int id) {
        if (id > 0) {
            return storage.search(id);
        }
        System.out.println("id inválido");
        return null;
    }

    public boolean delete(int id) {
        Movie movieToDelete = checkMovie(id);

        return storage.delete(movieToDelete);
    }

    public List<User> getUsers(int id) {
        Movie movie = checkMovie(id);
        return storage.getUsers(movie);
    }

}
