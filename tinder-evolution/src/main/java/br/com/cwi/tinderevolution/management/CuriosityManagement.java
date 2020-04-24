package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.storage.CuriosityStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuriosityManagement {

    private final CuriosityStorage storage = new CuriosityStorage();

//    older rule(v1)
//    public void checkExistent(Curiosity curiosity) {
//        for (Curiosity curiositiesExistent : list()) {
//            if (curiosity.getDescription().equals(curiositiesExistent.getDescription())) {
//                throw new RuntimeException("Curiosidade já cadastrada no sistema.");
//            }
//        }
//    }

    public void checkRules(Curiosity curiosity) {
        if (curiosity.getDescription().isEmpty() || curiosity.getCategory() == null) {
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

    public Curiosity create(Curiosity curiosity) {

        //checkExistent(curiosity);
        checkRules(curiosity);

        curiosity.setId(checkId());

        return storage.create(curiosity);
    }

    public List<Curiosity> list() {
        return storage.list();
    }

    public Curiosity edit(int id, Curiosity curiosityUpdated) {

        Curiosity curiosityToEdit = search(id);

//        older rule v1 (to change the category while keeping the same description)
//        if (!curiosityToEdit.getDescription().equals(curiosityUpdated.getDescription())){
//            checkExistent(curiosityUpdated);
//        }

        checkRules(curiosityUpdated);

        return storage.edit(curiosityToEdit, curiosityUpdated);
    }

    public Curiosity search(int id) {
        if (id > 0) {
            Curiosity curiosity = storage.search(id);
            if (curiosity == null) {
                throw new RuntimeException("Curiosidade não encontrada.");
            }
            return curiosity;
        }
        throw new RuntimeException("Id inválido");
    }

    public boolean delete(int id) {
        Curiosity curiosityToDelete = search(id);
        return storage.delete(curiosityToDelete);
    }

    public List<UserDTO> getUsers(int id) {
        Curiosity curiosity = search(id);

        //limited to 10 registers, following the rule in the project first scope
        return storage.getUsers(curiosity).stream().limit(10).collect(Collectors.toList());
    }
}
