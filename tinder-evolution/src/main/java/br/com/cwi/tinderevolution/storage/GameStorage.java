package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.user.UserDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static br.com.cwi.tinderevolution.domain.user.UserDTO.transformList;

public class GameStorage {

    private static final List<Game> games = new ArrayList<>();

    public Game create(Game game) {
        games.add(game);
        games.sort(Comparator.comparingInt(Game::getId));

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

    public boolean delete(Game gameToDelete) {
        games.remove(gameToDelete);
        return true;
    }

    public List<UserDTO> getUsers(Game game) {
        return transformList(game.getUsers());
    }

}
