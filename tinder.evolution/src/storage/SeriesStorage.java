package storage;

import objects.Series;

import java.util.ArrayList;
import java.util.List;

public class SeriesStorage {
    private static int contadorId = 1;
    private static List<Series> seriesList = new ArrayList<>();

    public Series create(Series series) {
        series.setId(contadorId++);
        seriesList.add(series);
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
