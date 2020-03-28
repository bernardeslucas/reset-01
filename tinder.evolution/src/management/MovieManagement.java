package management;

import objects.Movie;
import storage.MovieStorage;

import java.time.LocalDate;
import java.util.List;

public class MovieManagement {

    private MovieStorage storage = new MovieStorage();

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

    public Movie create(Movie movie) {
        List<Movie> movies = storage.list();
        for (Movie movieExistent : movies) {
            if (movie.getTitle().equals(movieExistent.getTitle())) {
                System.out.println("Filme já cadastrado.");
                return null;
            }
        }
        if (checkError(movie)) {
            return null;
        }
        return storage.create(movie);
    }

    public List<Movie> list(){
        return storage.list();
    }

    public Movie edit(int id, Movie movieUpdated) {
        Movie movieToEdit = search(id);
        if (movieToEdit == null) {
            System.out.println("\nUsuário não encontrado");
            return null;
        }
        if(!movieToEdit.getTitle().equals(movieUpdated.getTitle())){
            List<Movie> movies = storage.list();
            for (Movie movieExistent : movies) {
                if (movieUpdated.getTitle().equals(movieExistent.getTitle())) {
                    System.out.println("Filme já cadastrado.");
                    return null;
                }
            }
        }
        if (checkError(movieUpdated)){
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
        if (id > 0) {
            return storage.delete(id);
        }
        System.out.println("id inválido");
        return false;
    }

}
