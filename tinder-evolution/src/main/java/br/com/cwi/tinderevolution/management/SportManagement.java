package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.storage.SportStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportManagement {

    private SportStorage storage = new SportStorage();

    public boolean checkExistent(Sport sport) {
        List<Sport> sports = storage.list();
        for (Sport sportExistent : sports) {
            if (sport.getName().equals(sportExistent.getName())) {
                System.out.println("Jogo já cadastrado");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(Sport sport) {

        if (sport.getName().isEmpty()) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        return false;


    }

    public int checkId(Sport sport) {
        //to always get the lowest number(id) available

        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getId() != (i + 1)) {
                return i + 1;
            }
        }
        return storage.list().size() + 1;
    }

    public Sport create(Sport sport) {

        if (checkExistent(sport) || checkError(sport)) {
            return null;
        }
        sport.setId(checkId(sport));

        return storage.create(sport);
    }

    public List<Sport> list() {
        return storage.list();
    }

    public Sport edit(int id, Sport sportUpdated) {
        Sport sportToEdit = search(id);
        if (sportToEdit == null) {
            System.out.println("Jogo não encontrado");
            return null;
        }
        if (!sportToEdit.getName().equals(sportUpdated.getName())) {
            if (checkExistent(sportUpdated)) {
                return null;
            }
        }
        if (checkError(sportUpdated)) {
            return null;
        }
        return storage.edit(sportToEdit, sportUpdated);
    }

    public Sport search(int id) {
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
