package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class UserStorage {

    private static List<User> users = new ArrayList<>();

    public User create(User user) {
        users.add(user);
        users.sort(Comparator.comparingInt(User::getId));

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
        userToEdit.setPhotoUrl(userUpdated.photoUrl());

        return userToEdit;
    }

    public User search(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public boolean delete(int id) {
        User userToDelete = search(id);
        if (userToDelete != null) {
            return users.remove(userToDelete);
        }

        return false;
    }





}
