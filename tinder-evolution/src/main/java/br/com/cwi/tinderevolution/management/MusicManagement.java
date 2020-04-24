package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.storage.MusicStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.cwi.tinderevolution.domain.user.UserDTO.transform;

@Service
public class MusicManagement {

    private final MusicStorage storage = new MusicStorage();

    public void checkExistent(Music music) {

        for (Music musicsExistent : list()) {
            if (music.getTitle().equals(musicsExistent.getTitle())) {
                throw new RuntimeException("Música já cadastrada no sistema.");
            }
        }
    }

    public void checkRules(Music music) {
        if (music.getTitle().isEmpty() || music.getArtist().isEmpty() || music.getReleaseDate() == null || music.getMusicGenre() == null) {
            throw new RuntimeException("Algum atributo não preenchido.");
        }

        if (music.getReleaseDate().isAfter(LocalDate.now())) {
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

    public Music create(Music music) {
        checkExistent(music);
        checkRules(music);
        music.setId(checkId());

        return storage.create(music);
    }

    public List<Music> list() {
        return storage.list();
    }

    public Music edit(int id, Music musicUpdated) {

        Music musicToEdit = search(id);

        //check existent rule only if the title is different, because otherwise, you wouldn't get to edit other attributes while keeping the same title
        if (!musicToEdit.getTitle().equals(musicUpdated.getTitle())) {
            checkExistent(musicUpdated);
        }
        //check rules
        checkRules(musicUpdated);

        return storage.edit(musicToEdit, musicUpdated);
    }

    public Music search(int id) {
        //first, it checks to a valid input, and then looks into "database"
        if (id > 0) {
            Music music = storage.search(id);
            if (music == null) {
                throw new RuntimeException("Música não encontrada.");
            }
            return music;
        }
        throw new RuntimeException("Id inválido.");
    }

    public boolean delete(int id) {
        Music musicToDelete = search(id);
        return storage.delete(musicToDelete);
    }

    public List<UserDTO> getUsers(int id) {
        Music music = search(id);

        //limited to 10 registers, following the rule in the project first scope
        return storage.getUsers(music).stream().limit(10).collect(Collectors.toList());
    }

}
