package management;

import objects.Sport;
import storage.SportStorage;

import java.util.List;

public class SportManagement {

    private SportStorage storage = new SportStorage();


    public boolean checkError(Sport sport) {

        if (sport.getName().isEmpty()) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        return false;


    }

    public Sport create(Sport sport) {
        List<Sport> sports = storage.list();
        for (Sport sportExistent : sports) {
            if (sport.getName().equals(sportExistent.getName())) {
                System.out.println("Jogo já cadastrado");
                return null;
            }
        }

        if (checkError(sport)) {
            return null;
        }

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
        if(!sportToEdit.getName().equals(sportUpdated.getName())) {
            List<Sport> sports = storage.list();
            for (Sport sportExistent : sports) {
                if (sportUpdated.getName().equals(sportExistent.getName())) {
                    System.out.println("Jogo já cadastrado");
                    return null;
                }
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
