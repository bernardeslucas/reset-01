package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.SeriesStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SeriesManagement {

    private SeriesStorage storage = new SeriesStorage();

    public boolean checkExistent(Series series) {
        List<Series> seriesList = storage.list();
        for (Series seriesExistent : seriesList) {
            if (series.getName().equals(seriesExistent.getName())) {
                System.out.println("Série já cadastrada");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(Series series) {

        if (series.getName().isEmpty() || series.getDirector().isEmpty() ||
                series.getReleaseDate() == null || series.getSeriesGenre() == null ||
                series.getStoryLine().isEmpty()) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        if (series.getSeasonQty() < 1) {
            System.out.println("Séries precisam ter pelo menos 1 temporada.");
            return true;
        }
        if (series.getEpisodesQty() < 1) {
            System.out.println("Séries precisam ter pelo menos 1 episódio.");
            return true;
        }


        if (series.getReleaseDate().isAfter(LocalDate.now())) {
            System.out.println("\nData de lançamento futura.");
            return true;
        }

        return false;


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

    public Series checkSeries(int id){
        Series series = search(id);
        if (series == null) {
            throw new RuntimeException("Série não encontrada.");
        }
        return series;

    }

    public Series create(Series series) {

        if (checkExistent(series) || checkError(series)) {
            return null;
        }
        series.setId(checkId());

        return storage.create(series);
    }

    public List<Series> list() {
        return storage.list();
    }

    public Series edit(int id, Series seriesUpdated) {
        Series seriesToEdit = checkSeries(id);

        if (!seriesToEdit.getName().equals(seriesUpdated.getName())) {
            if (checkExistent(seriesUpdated)) {
                return null;
            }
        }

        if (checkError(seriesUpdated)) {
            return null;
        }
        return storage.edit(seriesToEdit, seriesUpdated);
    }

    public Series search(int id) {
        if (id > 0) {
            return storage.search(id);
        }
        System.out.println("Id inválido.");
        return null;
    }

    public boolean delete(int id) {
        Series seriesToDelete = checkSeries(id);
        return storage.delete(seriesToDelete);
    }

    public List<User> getUsers(int id) {
        Series series = checkSeries(id);
        return storage.getUsers(series);
    }

}
