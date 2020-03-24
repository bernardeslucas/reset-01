package consoleApp;

import management.MusicManagement;
import objects.Music;
import objects.MusicGenre;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MusicMenu {

    private MusicManagement management;

    public MusicMenu() {
        this.management = new MusicManagement();
    }

    public void opcoes() {
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("[1] Criar");
            System.out.println("[2] Editar");
            System.out.println("[3] Listar");
            System.out.println("[4] Procurar");
            System.out.println("[5] Deletar");
            System.out.println("[6] Voltar");
            System.out.print("> ");
            opcao = teclado.nextInt();

            switch (opcao) {
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

    public Music create() {

        Scanner teclado = new Scanner(System.in);
        System.out.println("\nCadastro de música..");

        System.out.print("Título: ");
        String titulo = teclado.nextLine();
        System.out.print("Artista: ");
        String autor = teclado.nextLine();
        System.out.print("Data de lançamento(yyyy-MM-dd): ");
        String dataLancamento = teclado.nextLine();

        System.out.println("Estilo:");
        System.out.println("[1] " + MusicGenre.FUNK.getDescricao());
        System.out.println("[2] " + MusicGenre.INDIE.getDescricao());
        System.out.println("[3] " + MusicGenre.METAL.getDescricao());
        System.out.println("[4] " + MusicGenre.PAGODE.getDescricao());
        System.out.println("[5] " + MusicGenre.ROCK.getDescricao());
        System.out.println("[6] " + MusicGenre.SERTANEJO.getDescricao());
        int estilo = teclado.nextInt();

        MusicGenre musicGenre = null;

        switch (estilo) {
            case 1:
                musicGenre = MusicGenre.FUNK;
                break;
            case 2:
                musicGenre = MusicGenre.INDIE;
                break;
            case 3:
                musicGenre = MusicGenre.METAL;
                break;
            case 4:
                musicGenre = MusicGenre.PAGODE;
                break;
            case 5:
                musicGenre = MusicGenre.ROCK;
                break;
            case 6:
                musicGenre = MusicGenre.SERTANEJO;
                break;
        }

        Music musicCreated = management.create(new Music(titulo, autor, LocalDate.parse(dataLancamento), musicGenre));

        return musicCreated;
    }

    private List<Music> list() {
        System.out.println("Lista de músicas..");
        List<Music> musicas = management.list();

        for (Music m : musicas) {
            System.out.println(m);
        }

        return musicas;
    }

    public Music edit() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nEditar música..");
        System.out.println("Qual música deseja editar?");

        List<Music> listaMusics = management.list();
        for (Music m : listaMusics) {
            System.out.println("[" + m.getId() + "] - " + m.getTitle());
        }
        System.out.print(">");
        int id = teclado.nextInt();
        teclado.nextLine(); //consumir o \n do input acima

        System.out.print("Título: ");
        String title = teclado.nextLine();
        System.out.print("Artista: ");
        String artist = teclado.nextLine();
        System.out.print("Data de lançamento (yyyy-MM-dd): ");
        String releaseDate = teclado.next();

        System.out.println("Estilo:");
        System.out.println("[1] " + MusicGenre.FUNK.getDescricao());
        System.out.println("[2] " + MusicGenre.INDIE.getDescricao());
        System.out.println("[3] " + MusicGenre.METAL.getDescricao());
        System.out.println("[4] " + MusicGenre.PAGODE.getDescricao());
        System.out.println("[5] " + MusicGenre.ROCK.getDescricao());
        System.out.println("[6] " + MusicGenre.SERTANEJO.getDescricao());
        int genreOption = teclado.nextInt();

        MusicGenre musicGenre = null;

        switch (genreOption) {
            case 1:
                musicGenre = MusicGenre.FUNK;
                break;
            case 2:
                musicGenre = MusicGenre.INDIE;
                break;
            case 3:
                musicGenre = MusicGenre.METAL;
                break;
            case 4:
                musicGenre = MusicGenre.PAGODE;
                break;
            case 5:
                musicGenre = MusicGenre.ROCK;
                break;
            case 6:
                musicGenre = MusicGenre.SERTANEJO;
                break;
        }

        Music musicUpdated = management.edit(id, new Music(title, artist, LocalDate.parse(releaseDate), musicGenre));

        if (musicUpdated == null) {
            System.out.println("Música não encontrada.");
        } else {
            System.out.println(musicUpdated);
        }
        return musicUpdated;
    }

    private void search() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nPesquisa de Música...");
        System.out.println("Qual o id da música?");
        System.out.print("> ");
        int id = teclado.nextInt();

        Music music = management.search(id);

        if (music == null) {
            System.out.println("Música não encontrada.");
        } else {
            System.out.println(music);
        }
    }

    private void delete() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nExclusão de Música...");
        System.out.println("Qual música deseja deletar (digite o id)?");

        List<Music> musicas = management.list();
        for (Music music : musicas) {
            System.out.println("[" + music.getId() + "] - " + music.getTitle());
        }

        System.out.print("> ");
        int id = teclado.nextInt();

        if (management.delete(id)) {
            System.out.println("Música deletada.");
        } else {
            System.out.println("Música não encontrada.");
        }
    }
}
