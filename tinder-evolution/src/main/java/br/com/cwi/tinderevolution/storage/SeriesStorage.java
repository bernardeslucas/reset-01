package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.series.Series;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class SeriesStorage {

    private static List<Series> seriesList = new ArrayList<>();

    public Series create(Series series) {

        seriesList.add(series);
        seriesList.sort(Comparator.comparingInt(Series::getId));
        return series;
    }

    public List<Series> list() {
        return seriesList;
    }

    public Series edit(Series seriesToEdit, Series seriesUpdated) {
        seriesToEdit.setName(seriesUpdated.getName());
        seriesToEdit.setDirector(seriesUpdated.getDirector());
        seriesToEdit.setReleaseDate(seriesUpdated.getReleaseDate());
        seriesToEdit.setSeasonQty(seriesUpdated.getSeasonQty());
        seriesToEdit.setEpisodesQty(seriesUpdated.getEpisodesQty());
        seriesToEdit.setSeriesGenre(seriesUpdated.getSeriesGenre());
        seriesToEdit.setStoryLine(seriesUpdated.getStoryLine());

        return seriesToEdit;

    }

    public Series search(int id) {
        for (Series series : seriesList) {
            if (series.getId() == id) {
                return series;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Series seriesToDelete = search(id);
        if (seriesToDelete != null) {
            return seriesList.remove(seriesToDelete);
        }
        return false;
    }

}
