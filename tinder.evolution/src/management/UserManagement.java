package management;

import objects.User;
import storage.UserStorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class UserManagement {

    private UserStorage storage = new UserStorage();


    public boolean checkExistent(User user) {
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

    public User create(User user) {
        if (checkExistent(user) || checkError(user)) {
            return null;
        }
        return storage.create(user);
    }

    public List<User> list() {
        return storage.list();
    }

    public User edit(int id, User userUpdated) {
        User userToEdit = search(id);
        if (userToEdit == null) {
            System.out.println("Usuário não encontrado");
            return null;
        }

        if (checkError(userUpdated)) {
            return null;
        }
        return storage.edit(userToEdit, userUpdated);
    }

    public User search(int id) {
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
