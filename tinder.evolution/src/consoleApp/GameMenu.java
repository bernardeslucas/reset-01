package consoleApp;

import management.GameManagement;
import objects.Game;
import objects.GameGenres;
import objects.GamePlatforms;

import java.time.LocalDate;
import java.util.List;

public class GameMenu {


    private GameManagement management;
    private CustomScanner scanner;

    protected GameMenu() {
        this.management = new GameManagement();
        this.scanner = new CustomScanner();
    }

    protected void options() {

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
                    System.out.println("Opção inválido.");
            }
        }
    }

    private Game info() {
        String name = scanner.nextLine("Nome: ");
        String publisher = scanner.nextLine("Distribuidora: ");
        String releaseDate = scanner.nextLine("Data de lançamento (yyyy-MM-dd): ");

        System.out.println("Categoria: ");
        int cont = 1;
        for (GameGenres genres : GameGenres.values()) {
            System.out.println("[" + cont + "] " + genres.getDescription());
            cont++;
        }
        int genreOption = scanner.nextInt("> ");

        GameGenres gameGenre = null;

        switch (genreOption) {
            case 1:
                gameGenre = GameGenres.ACTION;
                break;
            case 2:
                gameGenre = GameGenres.COMEDY;
                break;
            case 3:
                gameGenre = GameGenres.DRAMA;
                break;
            case 4:
                gameGenre = GameGenres.HORROR;
                break;
            case 5:
                gameGenre = GameGenres.MUSICAL;
                break;
            case 6:
                gameGenre = GameGenres.SUSPENSE;
                break;
        }
        cont = 1;
        System.out.println("Plataforma:");
        for (GamePlatforms platform : GamePlatforms.values()) {
            System.out.println("[" + cont + "] " + platform.getDescription());
            cont++;
        }
        int platformOption = scanner.nextInt("> ");
        GamePlatforms gamePlatform = null;

        switch (genreOption) {
            case 1:
                gamePlatform = GamePlatforms.PC;
                break;
            case 2:
                gamePlatform = GamePlatforms.PS4;
                break;
            case 3:
                gamePlatform = GamePlatforms.SNES;
                break;
            case 4:
                gamePlatform = GamePlatforms.XBOX;
                break;

        }


        Game game = new Game(name, publisher, LocalDate.parse(releaseDate), gameGenre, gamePlatform);

        return game;
    }

    private Game create() {

        System.out.println("Cadastro de jogo..");

        Game gameInfo = info();
        Game gameCreated = management.create(gameInfo);

        return gameCreated;
    }

    private Game edit() {
        System.out.println("Editar jogo..\nQual jogo deseja editar?");
        List<Game> listGames = management.list();
        for (Game u : listGames) {
            System.out.println("[" + u.getId() + "] - " + u.getName());
        }
        int id = scanner.nextInt(">");

        Game gameInfo = info();
        Game gameUpdoted = management.edit(id, gameInfo);

        return gameUpdoted;

    }

    private List<Game> list() {
        System.out.println("Lista de jogos..");
        List<Game> games = management.list();
        for (Game u : games) {
            System.out.println(u);
        }
        return games;
    }

    private void search() {
        System.out.println("Pesquisa de Jogo..\nQual o id do jogo?");
        int id = scanner.nextInt(">");

        Game game = management.search(id);

        if (game == null) {
            System.out.println("Jogo não encontrado.");
        } else {
            System.out.println(game);
        }
    }

    private void delete() {
        System.out.println("Exclusão de jogo..\nQual o id do jogo");
        List<Game> listGames = management.list();
        for (Game u : listGames) {
            System.out.println("[" + u.getId() + "] - " + u.getName());
        }
        int id = scanner.nextInt(">");

        if (management.delete(id)) {
            System.out.println("Jogo deletado.");
        } else {
            System.out.println("Jogo não encontrado.");
        }
    }
}
