package management;

import objects.Music;
import storage.MusicStorage;

import java.time.LocalDate;
import java.util.List;

public class MusicManagement {

    private MusicStorage storage = new MusicStorage();

    public Music create(Music music){

        List<Music> listaMusics = storage.list();

        for (Music musicaExistente : listaMusics){
            if(music.getTitle().equals(musicaExistente.getTitle())){
                return musicaExistente;
            }
        }

        if (music.getReleaseDate().isAfter(LocalDate.now())){
            return null;
        }


        return storage.create(music);



    }

    public List<Music> list() {
        return storage.list();
    }

    public Music edit(int id, Music musicUpdated){
        Music musicToEdit = search(id);
        if (musicToEdit==null){
            return null;
        }
        return storage.edit(musicToEdit,musicUpdated);

    }

    public Music search(int id){
        if(id>0){
            return storage.search(id);
        }
        return null;
    }

    public boolean delete(int id){
        if(id>0){
            return storage.delete(id);
        }
        return false;
    }


}
