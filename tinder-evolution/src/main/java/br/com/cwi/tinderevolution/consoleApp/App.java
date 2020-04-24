package br.com.cwi.tinderevolution.consoleApp;



public class App {


    public static void main(String[] args) {

        //left it excluded, because it no longer work, due to modifications to project v2

        CustomScanner scanner = new CustomScanner();
        MusicMenu musicMenu = new MusicMenu();
        UserMenu userMenu = new UserMenu();
        MovieMenu movieMenu = new MovieMenu();
        SeriesMenu seriesMenu = new SeriesMenu();
        GameMenu gameMenu = new GameMenu();
        SportMenu sportMenu = new SportMenu();
        CuriosityMenu curiosityMenu = new CuriosityMenu();

        int option = 0;

        while (option != 8) {
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Usuários");
            System.out.println("[2] Músicas");
            System.out.println("[3] Filmes");
            System.out.println("[4] Séries");
            System.out.println("[5] Jogos");
            System.out.println("[6] Esportes");
            System.out.println("[7] Curiosidades");
            System.out.println("[8] Encerrar");
            option = scanner.nextInt("> ");

            switch (option) {
                case 1:
                    userMenu.options();
                    break;
                case 2:
                    musicMenu.options();
                    break;
                case 3:
                    movieMenu.options();
                    break;
                case 4:
                    seriesMenu.options();
                    break;
                case 5:
                   gameMenu.options();
                    break;
                case 6:
                    sportMenu.options();
                    break;
                case 7:
                    curiosityMenu.options();
                    break;
                case 8:
                    System.out.println("Encerrando..");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        }
    }
}
