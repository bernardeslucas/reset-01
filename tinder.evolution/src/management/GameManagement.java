package management;

import objects.Game;
import storage.GameStorage;

import java.time.LocalDate;
import java.util.List;

public class GameManagement {
    private GameStorage storage = new GameStorage();


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

    public Game create(Game game) {
        List<Game> games = storage.list();
        for (Game gameExistent : games) {
            if (game.getName().equals(gameExistent.getName())) {
                System.out.println("Jogo já cadastrado");
                return null;
            }
        }
        if (checkError(game)) {

            return null;
        }
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
        if(!gameToEdit.getName().equals(gameUpdated.getName())){
            List<Game> games = storage.list();
            for (Game gameExistent : games) {
                if (gameUpdated.getName().equals(gameExistent.getName())) {
                    System.out.println("Jogo já cadastrado");
                    return null;
                }
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
