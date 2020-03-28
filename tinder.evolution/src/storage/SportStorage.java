package storage;

import objects.Sport;


import java.util.ArrayList;
import java.util.List;

public class SportStorage {
    private static int contadorId = 1;
    private static List<Sport> sports = new ArrayList<>();



    public Sport create(Sport sport) {
        sport.setId(contadorId++);
        sports.add(sport);
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
