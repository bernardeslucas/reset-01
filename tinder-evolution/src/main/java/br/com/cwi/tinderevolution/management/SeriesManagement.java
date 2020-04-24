package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.storage.SeriesStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesManagement {

    private final SeriesStorage storage = new SeriesStorage();

    public void checkExistent(Series series) {
        List<Series> seriesList = storage.list();
        for (Series seriesExistent : seriesList) {
            if (series.getName().equals(seriesExistent.getName())) {
                throw new RuntimeException("Série já cadastrada no sistema.");
            }
        }
    }

    public void checkRules(Series series) {

        if (series.getName().isEmpty() || series.getDirector().isEmpty() ||
                series.getReleaseDate() == null || series.getSeriesGenre() == null ||
                series.getStoryline().isEmpty()) {
            throw new RuntimeException("Algum atributo não preenchido.");
        }
        if (series.getSeasonQty() < 1) {
            throw new RuntimeException("Séries precisam ter pelo menos 1 temporada.");
        }
        if (series.getEpisodesQty() < 1) {
            throw new RuntimeException("Séries precisam ter pelo menos 1 episódio.");
        }
        if (series.getReleaseDate().isAfter(LocalDate.now())) {
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

    public Series create(Series series) {

        checkExistent(series);
        checkRules(series);
        series.setId(checkId());

        return storage.create(series);
    }

    public List<Series> list() {
        return storage.list();
    }

    public Series edit(int id, Series seriesUpdated) {
        Series seriesToEdit = search(id);

        //check existent rule only if the name is different, because otherwise, you wouldn't get to edit other attributes while keeping the same name
        if (!seriesToEdit.getName().equals(seriesUpdated.getName())) {
            checkExistent(seriesUpdated);
        }

        //check rules
        checkRules(seriesUpdated);

        return storage.edit(seriesToEdit, seriesUpdated);
    }

    public Series search(int id) {
        //first, it checks to a valid input, and then looks into "database"
        if (id > 0) {
            Series series = storage.search(id);
            if (series == null) {
                throw new RuntimeException("Série não encontrada.");
            }
            return series;
        }
        throw new RuntimeException("Id inválido.");
    }

    public boolean delete(int id) {
        Series seriesToDelete = search(id);

        return storage.delete(seriesToDelete);
    }

    public List<UserDTO> getUsers(int id) {
        Series series = search(id);

        //limited to 10 registers, following the rule in the project first scope
        return storage.getUsers(series).stream().limit(10).collect(Collectors.toList());
    }

}
