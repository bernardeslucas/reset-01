package br.com.cwi.tinderevolution.domain.game;

import br.com.cwi.tinderevolution.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private int id;
    private String name;
    private String publisher;
    private LocalDate releaseDate;
    private GameGenres gameGenre;
    private GamePlatforms gamePlatform;
    private final List<User> users = new ArrayList<>();

    public Game(String name, String publisher, LocalDate releaseDate, GameGenres gameGenre, GamePlatforms gamePlatform) {
        this.name = name;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.gameGenre = gameGenre;
        this.gamePlatform = gamePlatform;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public GameGenres getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(GameGenres gameGenre) {
        this.gameGenre = gameGenre;
    }

    public GamePlatforms getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(GamePlatforms gamePlatform) {
        this.gamePlatform = gamePlatform;
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
                "', Editora: " + publisher +
                "', Data de lançamento: '" + releaseDate +
                "', Categoria: '" + gameGenre.getDescription() +
                "', Plataforma: '" + gamePlatform + "']";
    }
}
