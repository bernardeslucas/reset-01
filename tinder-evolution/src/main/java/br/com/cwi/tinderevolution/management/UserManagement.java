package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.UserStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class UserManagement {

    private UserStorage storage = new UserStorage();

    public boolean checkExistent(User user) {
        // existent rule
        List<User> userList = storage.list();
        for (User userExistent : userList) {
            if (user.getEmail().equals(userExistent.getEmail())) {
                System.out.println("Este e-mail já está em uso.");
                return true;
            }
        }
        return false;
    }

    public boolean checkError(User user) {
        // attribute rules
        if (user.getName().isEmpty() || user.getEmail().isEmpty() ||
                user.getPhone().isEmpty() || user.getBirthDate() == null ||
                user.getBio().isEmpty() || user.getLatitude() == null || user.getLongitude() == null) {
            System.out.println("\nAlguma informação não preenchida.");
            return true;
        }

        if (Period.between(user.getBirthDate(), LocalDate.now()).getYears() < 18) {
            System.out.println("Este aplicativo é somente para maiores de 18 anos.");
            return true;
        }

        return false;

    }

    public int checkId(User user) {
        //to always get the lowest number(id) available

        for (int i = 0; i < storage.list().size(); i++) {
            if (storage.list().get(i).getId() != (i + 1)) {
                return i + 1;
            }
        }
        return storage.list().size() + 1;
    }

    public User create(User user) {
        if (checkExistent(user) || checkError(user)) {
            return null;
        }
        user.setId(checkId(user));
        return storage.create(user);
    }

    public List<User> list() {
        return storage.list();
    }

    public User edit(int id, User userUpdated) {

        User userToEdit = search(id);

        if (userToEdit == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        //check existent rule only if the e-mail is different, because otherwise, you wouldn't get to edit other attributes and keep the same e-mail
        if (!userToEdit.getEmail().equals(userUpdated.getEmail())) {
            if (checkExistent(userUpdated)) {
                return null;
            }
        }

        //check attributes error
        if (checkError(userUpdated)) {
            return null;
        }
        return storage.edit(userToEdit, userUpdated);
    }

    public User search(int id) {
        if (id > 0) {
            return storage.search(id);
        }
        throw new RuntimeException("Id inválido");
    }

    public boolean delete(int id) {
        if (id > 0) {
            return storage.delete(id);
        }
        System.out.println("id inválido");
        return false;
    }


}