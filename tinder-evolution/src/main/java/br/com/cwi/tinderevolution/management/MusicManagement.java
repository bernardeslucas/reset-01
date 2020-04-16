package br.com.cwi.tinderevolution.management;


import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.storage.MusicStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
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

    public int checkId(Music music) {
        //to always get the lowest number(id) available

        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getId() != (i + 1)) {
                return i + 1;
            }
        }
        return storage.list().size() + 1;
    }

    public Music create(Music music) {
        if (checkExistent(music) || checkError(music)) {
            return null;
        }

        music.setId(checkId(music));

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
        //check existent rule only if the e-mail is different, because otherwise, you wouldn't get to edit other attributes and keep the same e-mail
        if (!musicToEdit.getTitle().equals(musicUpdated.getTitle())) {
            if (checkExistent(musicUpdated)) {
                return null;
            }
        }
        //check attributes error
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
