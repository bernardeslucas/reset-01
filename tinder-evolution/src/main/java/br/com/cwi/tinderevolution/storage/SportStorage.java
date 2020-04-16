package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.sport.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class SportStorage {

    private static List<Sport> sports = new ArrayList<>();

    public Sport create(Sport sport) {
        sports.add(sport);
        sports.sort(Comparator.comparingInt(Sport::getId));

        return sport;
    }

    public List<Sport> list() {
        return sports;
    }

    public Sport edit(Sport sportToEdit, Sport sportUpdated) {
        sportToEdit.setName(sportUpdated.getName());

        return sportToEdit;
    }

    public Sport search(int id) {
        for (Sport sport : sports) {
            if (sport.getId() == id) {
                return sport;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Sport sportToDelete = search(id);
        if (sportToDelete != null) {
            return sports.remove(sportToDelete);
        }

        return false;
    }
}
