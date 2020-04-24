package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.storage.SportStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportManagement {

    private final SportStorage storage = new SportStorage();

    public void checkExistent(Sport sport) {

        for (Sport sportsExistent : list()) {
            if (sport.getName().equals(sportsExistent.getName())) {
                throw new RuntimeException("Jogo já cadastrado no sistema.");
            }
        }
    }

    public void checkRules(Sport sport) {

        if (sport.getName().isEmpty()) {
            throw new RuntimeException("Algum atributo não preenchido.");
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

    public Sport create(Sport sport) {
        checkExistent(sport);
        checkRules(sport);
        sport.setId(checkId());

        return storage.create(sport);
    }

    public List<Sport> list() {
        return storage.list();
    }

    public Sport edit(int id, Sport sportUpdated) {
        Sport sportToEdit = search(id);

        checkExistent(sportUpdated);
        checkRules(sportUpdated);

        return storage.edit(sportToEdit, sportUpdated);
    }

    public Sport search(int id) {
        //first, it checks to a valid input, and then looks into "database"
        if (id > 0) {
            Sport sport = storage.search(id);
            if (sport == null) {
                throw new RuntimeException("Esporte não encontrado.");
            }
            return sport;
        }
        throw new RuntimeException("Id inválido");
    }

    public boolean delete(int id) {
        Sport sportToDelete = search(id);
        return storage.delete(sportToDelete);
    }

    public List<UserDTO> getUsers(int id) {
        Sport sport = search(id);
        //limited to 10 registers, following the rule in the project first scope
        return storage.getUsers(sport).stream().limit(10).collect(Collectors.toList());
    }
}
