package storage;

import objects.Game;


import java.util.ArrayList;
import java.util.List;

public class GameStorage {
    private static int contadorId = 1;
    private static List<Game> games = new ArrayList<>();

    public Game create(Game game) {
        game.setId(contadorId++);
        games.add(game);
        return game;
    }

    public List<Game> list() {
        return games;
    }

    public Game edit(Game gameToEdit, Game gameUpdated) {
        gameToEdit.setName(gameUpdated.getName());
        gameToEdit.setPublisher(gameUpdated.getPublisher());
        gameToEdit.setReleaseDate(gameUpdated.getReleaseDate());
        gameToEdit.setGameGenre(gameUpdated.getGameGenre());
        gameToEdit.setGamePlatform(gameUpdated.getGamePlatform());

        return gameToEdit;
    }

    public Game search(int id) {
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Game gameToDelete = search(id);
        if (gameToDelete != null) {
            return games.remove(gameToDelete);
        }

        return false;
    }






}
