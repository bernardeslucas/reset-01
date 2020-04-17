package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.CuriosityStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuriosityManagement {

    private CuriosityStorage storage = new CuriosityStorage();

    public boolean checkExistent (Curiosity curiosity){
        List<Curiosity> curiosities = storage.list();
        for (Curiosity curiosityExistent : curiosities) {
            if (curiosity.getDescription().equals(curiosityExistent.getDescription())) {
                System.out.println("Descrição já cadastrada em outra curiosidade");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(Curiosity curiosity) {
        if (curiosity.getDescription().isEmpty() || curiosity.getCategory() == null) {
            System.out.println("\nAlguma informação não preenchida.");

            return true;
        }

        return false;
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

    public Curiosity create(Curiosity curiosity) {

        if (checkExistent(curiosity) || checkError(curiosity)) {
            return null;
        }

        curiosity.setId(checkId());

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

        //check existent rule only if the e-mail is different, because otherwise, you wouldn't get to edit other attributes and keep the same e-mail
        if(!curiosityToEdit.getDescription().equals(curiosityUpdated.getDescription())) {
            if(checkExistent(curiosityUpdated)){
                return null;
            }
        }

        //check attributes error
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
