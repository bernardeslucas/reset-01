package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.storage.MovieStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieManagement {

    private final MovieStorage storage = new MovieStorage();

    public void checkExistent(Movie movie) {

        for (Movie moviesExistent : list()) {
            if (movie.getTitle().equals(moviesExistent.getTitle())) {
                throw new RuntimeException("Filme já cadastrado no sistema.");
            }
        }
    }

    public void checkRules(Movie movie) {

        if (movie.getTitle().isEmpty() || movie.getDirector().isEmpty() || movie.getReleaseDate() == null || movie.getMovieGenre() == null || movie.getStoryline().isEmpty()) {
            throw new RuntimeException("Algum atributo não preenchido.");
        }

        if (movie.getReleaseDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Data de lançamento futura.");
        }
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

    public Movie create(Movie movie) {

        checkExistent(movie);
        checkRules(movie);
        movie.setId(checkId());

        return storage.create(movie);
    }

    public List<Movie> list() {
        return storage.list();
    }

    public Movie edit(int id, Movie movieUpdated) {
        Movie movieToEdit = search(id);

        //check existent rule only if the title is different, because otherwise, you wouldn't get to edit other attributes while keeping the same title
        if (!movieToEdit.getTitle().equals(movieUpdated.getTitle())) {
            checkExistent(movieUpdated);
        }
        checkRules(movieUpdated);
        return storage.edit(movieToEdit, movieUpdated);
    }

    public Movie search(int id) {
        //first, it checks to a valid input, and then looks into "database"
        if (id > 0) {
            Movie movie = storage.search(id);
            if (movie == null) {
                throw new RuntimeException("Filme não encontrado.");
            }
            return movie;
        }
        throw new RuntimeException("Id inválido");
    }

    public boolean delete(int id) {
        Movie movieToDelete = search(id);

        return storage.delete(movieToDelete);
    }

    public List<UserDTO> getUsers(int id) {
        Movie movie = search(id);
        //limited to 10 registers, following the rule in the project first scope
        return storage.getUsers(movie).stream().limit(10).collect(Collectors.toList());
    }

}
