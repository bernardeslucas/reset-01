package storage;

import objects.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static int contadorId = 1;
    private static List<User> users = new ArrayList<>();

    public User create(User user) {
        user.setId(contadorId++);
        users.add(user);
        return user;
    }

    public List<User> list() {
        return users;
    }

    public User edit(User userToEdit, User userUpdated) {
        userToEdit.setName(userUpdated.getName());
        userToEdit.setEmail(userUpdated.getEmail());
        userToEdit.setPhone(userUpdated.getPhone());
        userToEdit.setBirthDate(userUpdated.getBirthDate());
        userToEdit.setBio(userUpdated.getBio());
        userToEdit.setLatitude(userUpdated.getLatitude());
        userToEdit.setLongitude(userUpdated.getLongitude());

        return userToEdit;
    }

    public User search(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public boolean delete (int id){
        User userToDelete = search(id);
        if(userToDelete!=null){
            return users.remove(userToDelete);
        }
        return false;
    }

}
