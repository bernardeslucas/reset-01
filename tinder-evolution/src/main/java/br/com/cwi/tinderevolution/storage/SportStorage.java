package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static br.com.cwi.tinderevolution.domain.user.UserDTO.transformList;

@Repository
public class SportStorage {

    private static final List<Sport> sports = new ArrayList<>();

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

    public boolean delete(Sport sportToDelete) {
        sports.remove(sportToDelete);
        return true;
    }

    public List<UserDTO> getUsers(Sport sport) {
        return transformList(sport.getUsers());
    }
}
