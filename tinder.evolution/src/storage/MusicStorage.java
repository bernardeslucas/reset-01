package storage;

import objects.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicStorage {

    private static final List<Music> musicas = new ArrayList<>();
    private static int contadorId = 1;

    public Music create(Music music) {
        music.setId(contadorId++);
        musicas.add(music);
        return music;
    }

    public List<Music> list() {
        return musicas;
    }

    public Music edit(Music musicToEdit, Music musicUpdated) {
        musicToEdit.setTitle(musicUpdated.getTitle());
        musicToEdit.setArtist(musicUpdated.getArtist());
        musicToEdit.setReleaseDate(musicUpdated.getReleaseDate());
        musicToEdit.setMusicGenre(musicUpdated.getMusicGenre());

        return musicToEdit;
    }

    public Music search(int id) {
        for (Music music : musicas) {
            if (music.getId() == id) {
                return music;
            }
        }
        return null;
    }

    public boolean delete(int id) {

        Music musicaParaDeletar = search(id);
        if (musicaParaDeletar != null) {
            return musicas.remove(musicaParaDeletar);
        }
        return false;
    }


}
