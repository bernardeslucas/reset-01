package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.storage.GameStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameManagement {

    private final GameStorage storage = new GameStorage();

    public void checkExistent(Game game) {

        for (Game gameExistent : storage.list()) {
            if (game.getName().equals(gameExistent.getName()) && game.getGamePlatform().equals(gameExistent.getGamePlatform())) {
                throw new RuntimeException("Este jogo já está cadastrado nessa plataforma");
            }
        }
    }

    public void checkRules(Game game) {

        if (game.getName().isEmpty() || game.getReleaseDate() == null || game.getGameGenre() == null || game.getGamePlatform() == null) {
            throw new RuntimeException("Algum atributo não preenchido.");
        }

        if (game.getReleaseDate().isAfter(LocalDate.now())) {
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

    public Game create(Game game) {

        checkExistent(game);
        checkRules(game);
        game.setId(checkId());

        return storage.create(game);
    }

    public List<Game> list() {
        return storage.list();
    }

    public Game edit(int id, Game gameUpdated) {
        Game gameToEdit = search(id);

        //check existent rule only if the name/platform is different, because otherwise, you wouldn't get to edit other attributes while keeping the same name/platform
        if (!gameToEdit.getName().equals(gameUpdated.getName()) && !gameToEdit.getGamePlatform().equals(gameUpdated.getGamePlatform())) {
            checkExistent(gameUpdated);
        }
        //check rules
        checkRules(gameUpdated);

        return storage.edit(gameToEdit, gameUpdated);
    }

    public Game search(int id) {
        if (id > 0) {
            Game game = storage.search(id);
            if (game == null) {
                throw new RuntimeException("Música não encontrada.");
            }
            return game;
        }
        throw new RuntimeException("Id inválido");
    }

    public boolean delete(int id) {
        Game gameToDelete = search(id);
        return storage.delete(gameToDelete);
    }

    public List<UserDTO> getUsers(int id) {
        Game game = search(id);
        //limited to 10 registers, following the rule in the project first scope
        return storage.getUsers(game).stream().limit(10).collect(Collectors.toList());
    }
}
