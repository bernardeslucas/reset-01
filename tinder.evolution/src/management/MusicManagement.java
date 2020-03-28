package management;

import objects.Music;
import storage.MusicStorage;

import java.time.LocalDate;
import java.util.List;

public class MusicManagement {

    private MusicStorage storage = new MusicStorage();

    public boolean checkExistent(Music music) {
        List<Music> listaMusics = storage.list();
        for (Music musicaExistente : listaMusics) {
            if (music.getTitle().equals(musicaExistente.getTitle())) {
                System.out.println("\nMúsica já existente.");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(Music music) {
        if (music.getTitle().isEmpty() || music.getArtist().isEmpty() || music.getReleaseDate() == null || music.getMusicGenre() == null) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }


        if (music.getReleaseDate().isAfter(LocalDate.now())) {
            System.out.println("\nData de lançamento futura.");
            return true;
        }

        return false;

    }

    public Music create(Music music) {
        if (checkExistent(music)) {
            return null;
        }

        if (checkError(music)) {
            return null;
        }

        return storage.create(music);
    }

    public List<Music> list() {
        return storage.list();
    }

    public Music edit(int id, Music musicUpdated) {
        Music musicToEdit = search(id);
        if (musicToEdit == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }
        if (!musicToEdit.getTitle().equals(musicUpdated.getTitle())) {
            if (checkExistent(musicUpdated)) {
                return null;
            }
        }
        if (checkError(musicUpdated)) {
            return null;
        }
        return storage.edit(musicToEdit, musicUpdated);

    }

    public Music search(int id) {
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
