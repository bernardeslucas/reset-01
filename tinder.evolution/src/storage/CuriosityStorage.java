package storage;

import objects.Curiosity;

import java.util.ArrayList;
import java.util.List;

public class CuriosityStorage {

    private static int contadorId = 1;
    private static List<Curiosity> curiosities = new ArrayList<>();

    public Curiosity create(Curiosity curiosity) {
        curiosity.setId(contadorId++);
        curiosities.add(curiosity);
        return curiosity;
    }

    public List<Curiosity> list() {
        return curiosities;
    }

    public Curiosity edit(Curiosity curiosityToEdit, Curiosity curiosityUpdated) {
        curiosityToEdit.setDescription(curiosityUpdated.getDescription());
        curiosityToEdit.setCategory(curiosityUpdated.getCategory());


        return curiosityToEdit;
    }

    public Curiosity search(int id) {
        for (Curiosity curiosity : curiosities) {
            if (curiosity.getId() == id) {
                return curiosity;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        Curiosity curiosityToDelete = search(id);
        if (curiosityToDelete != null) {
            return curiosities.remove(curiosityToDelete);
        }

        return false;
    }

}
