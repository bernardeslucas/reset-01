package consoleApp;

import management.MusicManagement;
import objects.Music;
import objects.MusicGenres;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MusicMenu {

    private MusicManagement management;
    private CustomScanner scanner;

    public MusicMenu() {
        this.management = new MusicManagement();
        this.scanner = new CustomScanner();
    }

    public void options() {

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

    public Music info() {
        String title = scanner.nextLine("Título: ");
        String artist = scanner.nextLine("Artista: ");
        String releaseDate = scanner.nextLine("Data de lançamento (yyyy-MM-dd): ");

        System.out.println("Estilo: ");
        int cont = 1;
        for (MusicGenres genres : MusicGenres.values()) {
            System.out.println("[" + cont + "] " + genres.getDescricao());
            cont++;
        }
        int genreOption = scanner.nextInt("> ");

        MusicGenres musicGenre = null;

        switch (genreOption) {
            case 1:
                musicGenre = MusicGenres.FUNK;
                break;
            case 2:
                musicGenre = MusicGenres.INDIE;
                break;
            case 3:
                musicGenre = MusicGenres.METAL;
                break;
            case 4:
                musicGenre = MusicGenres.PAGODE;
                break;
            case 5:
                musicGenre = MusicGenres.ROCK;
                break;
            case 6:
                musicGenre = MusicGenres.SERTANEJO;
                break;
        }
        Music music = new Music(title, artist, LocalDate.parse(releaseDate), musicGenre);
        return music;
    }

    public Music create() {


        System.out.println("\nCadastro de música..");

        Music music = info();

        Music musicCreated = management.create(music);



        return musicCreated;
    }

    public Music edit() {

        System.out.println("\nEditar música..");
        System.out.println("Qual música deseja editar?");

        List<Music> listaMusics = management.list();
        for (Music m : listaMusics) {
            System.out.println("[" + m.getId() + "] - " + m.getTitle());
        }

        int id = scanner.nextInt("> ");
        Music music = info();

        Music musicUpdated = management.edit(id, music);

        if (musicUpdated != null) {
            System.out.println("\nMúsica editada com sucesso.\n" + musicUpdated);
        }
        return musicUpdated;
    }

    private List<Music> list() {
        System.out.println("Lista de músicas..");
        List<Music> musics = management.list();

        for (Music m : musics) {
            System.out.println(m);
        }

        return musics;
    }

    private void search() {

        int id = scanner.nextInt("\nPesquisa de música..\nQual o id da música?\n> ");

        Music music = management.search(id);

        if (music == null) {
            System.out.println("Música não encontrada.");
        } else {
            System.out.println(music);
        }
    }

    private void delete() {

        System.out.println("\nExclusão de Música...");
        System.out.println("Qual música deseja deletar (digite o id)?");

        List<Music> musicas = management.list();
        for (Music music : musicas) {
            System.out.println("[" + music.getId() + "] - " + music.getTitle());
        }


        int id = scanner.nextInt("> ");

        if (management.delete(id)) {
            System.out.println("Música deletada.");
        } else {
            System.out.println("Música não encontrada.");
        }
    }
}
