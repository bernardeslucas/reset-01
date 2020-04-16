package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.storage.GameStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GameManagement {

    private GameStorage storage = new GameStorage();

    public boolean checkExistente(Game game) {
        List<Game> games = storage.list();
        for (Game gameExistent : games) {
            if (game.getName().equals(gameExistent.getName()) && game.getGamePlatform().equals(gameExistent.getGamePlatform())) {
                System.out.println("Este jogo já está cadastrado nessa plataforma");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(Game game) {

        if (game.getName().isEmpty() || game.getPublisher().isEmpty() ||
                game.getReleaseDate() == null || game.getGameGenre() == null ||
                game.getGamePlatform() == null) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        if (game.getReleaseDate().isAfter(LocalDate.now())) {
            System.out.println("\nData de lançamento futura.");
            return true;
        }

        return false;
    }

    public int checkId(Game game) {
        //to always get the lowest number(id) available

        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getId() != (i + 1)) {
                return i + 1;
            }
        }
        return storage.list().size() + 1;
    }

    public Game create(Game game) {

        if (checkExistente(game) || checkError(game)) {
            return null;
        }
        game.setId(checkId(game));

        return storage.create(game);
    }

    public List<Game> list() {
        return storage.list();
    }

    public Game edit(int id, Game gameUpdated) {
        Game gameToEdit = search(id);
        if (gameToEdit == null) {
            System.out.println("Jogo não encontrado");
            return null;
        }
        if (!gameToEdit.getName().equals(gameUpdated.getName())) {
            if (checkExistente(gameUpdated)) {
                return null;
            }
        }

        if (checkError(gameUpdated)) {
            return null;
        }
        return storage.edit(gameToEdit, gameUpdated);
    }

    public Game search(int id) {
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
