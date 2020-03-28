package consoleApp;

import management.SeriesManagement;
import objects.MusicGenres;
import objects.Series;
import objects.SeriesGenres;

import java.time.LocalDate;
import java.util.List;

public class SeriesMenu {

    private SeriesManagement management;
    private CustomScanner scanner;

    protected SeriesMenu() {
        this.management = new SeriesManagement();
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
                    System.out.println("Opção inválida.");
            }
        }
    }

    private Series info(){
        String name = scanner.nextLine("Nome: ");
        String director = scanner.nextLine("Diretor: ");
        String releaseDate = scanner.nextLine("Data de lançamento (yyyy-MM-dd): ");
        int seasonsQty = scanner.nextInt("Número de temporadas: ");
        int episodesQty = scanner.nextInt("Número de episódios: ");
        String storyLine = scanner.nextLine("Sinopse: ");

        System.out.println("Categoria: ");
        int cont = 1;
        for (SeriesGenres genres : SeriesGenres.values()) {
            System.out.println("[" + cont + "] " + genres.getDescription());
            cont++;
        }
        int genreOption = scanner.nextInt("> ");

        SeriesGenres serieGenre = null;

        switch (genreOption) {
            case 1:
                serieGenre = SeriesGenres.ACTION;
                break;
            case 2:
                serieGenre = SeriesGenres.COMEDY;
                break;
            case 3:
                serieGenre = SeriesGenres.DRAMA;
                break;
            case 4:
                serieGenre = SeriesGenres.HORROR;
                break;
            case 5:
                serieGenre = SeriesGenres.SITCOM;
                break;
            case 6:
                serieGenre = SeriesGenres.SUSPENSE;
                break;
        }


        Series series = new Series(name, director, LocalDate.parse(releaseDate), seasonsQty, episodesQty, serieGenre, storyLine);

        return series;
    }

    private Series create() {

        System.out.println("Cadastro de série..");

        Series seriesInfo = info();
        Series seriesCreated = management.create(seriesInfo);

        return seriesCreated;
    }

    private Series edit() {
        System.out.println("Editar série..\nQual série deseja editar?");
        List<Series> listSeriess = management.list();
        for (Series u : listSeriess) {
            System.out.println("[" + u.getId() + "] - " + u.getName());
        }
        int id = scanner.nextInt(">");

        Series seriesInfo = info();
        Series seriesUpdated = management.edit(id, seriesInfo);

        return seriesUpdated;

    }

    private List<Series> list() {
        System.out.println("Lista de séries..");
        List<Series> seriess = management.list();
        for (Series u : seriess) {
            System.out.println(u);
        }
        return seriess;
    }

    private void search() {
        System.out.println("Pesquisa de Série..\nQual o id da série?");
        int id = scanner.nextInt(">");

        Series series = management.search(id);

        if (series == null) {
            System.out.println("Série não encontrada.");
        } else {
            System.out.println(series);
        }
    }

    private void delete() {
        System.out.println("Exclusão de série..\nQual o id da série");
        List<Series> listSeriess = management.list();
        for (Series u : listSeriess) {
            System.out.println("[" + u.getId() + "] - " + u.getName());
        }
        int id = scanner.nextInt(">");

        if (management.delete(id)) {
            System.out.println("Série deletada.");
        } else {
            System.out.println("Série não encontrada.");
        }
    }

}
