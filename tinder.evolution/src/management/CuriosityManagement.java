package management;

import objects.Curiosity;
import storage.CuriosityStorage;

import java.util.List;

public class CuriosityManagement {

    private CuriosityStorage storage = new CuriosityStorage();


    public boolean checkError(Curiosity curiosity) {



        if (curiosity.getDescription().isEmpty() || curiosity.getCategory() == null) {

            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        return false;


    }

    public Curiosity create(Curiosity curiosity) {
        List<Curiosity> curiosities = storage.list();
        for (Curiosity curiosityExistent : curiosities) {
            if (curiosity.getDescription().equals(curiosityExistent.getDescription())) {
                System.out.println("Descrição já cadastrada em outra curiosidade");
                return null;
            }
        }

        if (checkError(curiosity)) {
            return null;
        }
        return storage.create(curiosity);
    }

    public List<Curiosity> list() {
        return storage.list();
    }

    public Curiosity edit(int id, Curiosity curiosityUpdated) {
        Curiosity curiosityToEdit = search(id);
        if (curiosityToEdit == null) {
            System.out.println("Curiosidade não encontrada");
            return null;
        }
        if(!curiosityToEdit.getDescription().equals(curiosityUpdated.getDescription())) {
            List<Curiosity> curiosities = storage.list();
            for (Curiosity curiosityExistent : curiosities) {
                if (curiosityUpdated.getDescription().equals(curiosityExistent.getDescription())) {
                    System.out.println("Descrição já cadastrada em outra curiosidade");
                    return null;
                }
            }
        }
        if (checkError(curiosityUpdated)) {
            return null;
        }
        return storage.edit(curiosityToEdit, curiosityUpdated);
    }

    public Curiosity search(int id) {
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
