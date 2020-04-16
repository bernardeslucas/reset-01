package br.com.cwi.tinderevolution.consoleApp;

import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.movie.MovieGenres;
import br.com.cwi.tinderevolution.management.MovieManagement;

import java.time.LocalDate;
import java.util.List;

public class MovieMenu {
    private MovieManagement management;
    private CustomScanner scanner;

    public MovieMenu() {
        this.management = new MovieManagement();
        this.scanner = new CustomScanner();
    }

    public void options() {
        int option = 0;

        while (option != 6) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("[1] Criar");
            System.out.println("[2] Editar");
            System.out.println("[3] Listar");
            System.out.println("[4] Procurar");
            System.out.println("[5] Deletar");
            System.out.println("[6] Voltar");

            option = scanner.nextInt("> ");

            switch (option) {
                case 1:
                    create();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    }

    public Movie info() {

        String title = scanner.nextLine("Título: ");
        String director = scanner.nextLine("Diretor: ");
        String releaseDate = scanner.nextLine("Data de lançamento (yyyy-MM-dd): ");
        String storyLine = scanner.nextLine("Sinopse: ");

        System.out.println("Categoria: ");
        int cont = 1;
        for (MovieGenres genres : MovieGenres.values()) {
            System.out.println("[" + cont + "] " + genres.getDescription());
            cont++;
        }
        int genreOption = scanner.nextInt("> ");

        MovieGenres movieGenre = null;
        switch (genreOption) {
            case 1:
                movieGenre = MovieGenres.ACAO;
                break;
            case 2:
                movieGenre = MovieGenres.COMEDIA;
                break;
            case 3:
                movieGenre = MovieGenres.DRAMA;
                break;
            case 4:
                movieGenre = MovieGenres.MUSICAL;
                break;
            case 5:
                movieGenre = MovieGenres.SUSPENSE;
                break;
            case 6:
                movieGenre = MovieGenres.TERROR;
                break;
        }
        Movie movie = new Movie(title, director, LocalDate.parse(releaseDate), movieGenre, storyLine);
        return movie;
    }

    public Movie create() {
        System.out.println("Criação de filme..");
        Movie movie = info();
        Movie movieCreated = management.create(movie);

        return movieCreated;
    }

    public List<Movie> list(){
        System.out.println("Lista de filmes..");
        List<Movie> movies = management.list();
        for (Movie m : movies){
            System.out.println(m);
        }
        return movies;
    }

    public Movie edit() {
        System.out.println("\nEditar filme..\nQual filme deseja editar?");


        List<Movie> movies = management.list();
        for (Movie m : movies) {
            System.out.println("[" + m.getId() + "] - " + m.getTitle());
        }

        int id = scanner.nextInt("> ");
        if (management.search(id) == null) {
            System.out.println("Filme não encontrada.");
            return null;
        }
        Movie movie = info();

        Movie movieUpdated = management.edit(id, movie);

        return movieUpdated;
    }

    public void search() {
        int id = scanner.nextInt("Pesquisa de filme..\nQual o id do filme?\n> ");
        Movie movie = management.search(id);

        if (movie == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println(movie);
        }

    }

    private void delete() {
        System.out.println("\nExclusão de filme..\nQual filme deseja deletar (digite o id)?");
        List<Movie> movies = management.list();
        for (Movie movie : movies) {
            System.out.println("[" + movie.getId() + "] - " + movie.getTitle());
        }
        int id = scanner.nextInt("> ");

        if (management.delete(id)) {
            System.out.println("Filme deletado.");
        } else {
            System.out.println("Filme não encontrado.");
        }
    }
}
