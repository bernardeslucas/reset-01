package management;

import objects.Series;
import storage.SeriesStorage;

import java.time.LocalDate;
import java.util.List;

public class SeriesManagement {
    private SeriesStorage storage = new SeriesStorage();


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

    public Series create(Series series) {
        // essa verificação está aqui e nao no metodo check, por causa do conflito no edit.
        List<Series> seriesList = storage.list();
        for (Series seriesExistent : seriesList) {
            if (series.getName().equals(seriesExistent.getName())) {
                System.out.println("Série já cadastrada");
                return null;
            }
        }
        if (checkError(series)) {
            return null;
        }
        return storage.create(series);
    }

    public List<Series> list() {
        return storage.list();
    }

    public Series edit(int id, Series seriesUpdated) {
        Series seriesToEdit = search(id);

        if (seriesToEdit == null) {
            System.out.println("Série não encontrada");
            return null;
        }
        // essa verificação está aqui e nao no metodo check, por causa do conflito no edit.
        if (!seriesToEdit.getName().equals(seriesUpdated.getName())) {
            List<Series> seriesList = storage.list();
            for (Series seriesExistent : seriesList) {
                if (seriesUpdated.getName().equals(seriesExistent.getName())) {
                    System.out.println("Série já cadastrada");
                    return null;
                }
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
