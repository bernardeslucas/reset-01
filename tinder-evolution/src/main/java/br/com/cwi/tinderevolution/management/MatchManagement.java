package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.MatchStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchManagement {
    private MatchStorage matchStorage = new MatchStorage();
    private UserManagement userManagement = new UserManagement();

    public void checkUsers(User user1, User user2) {
        if (user1 == null || user2 == null) {
            throw new RuntimeException("Usuário(s) não encontrado(s).");
        }
    }

    //likes
    public List<User> usersLiked(int id) {
        User user = userManagement.search(id);
        if (user == null) {
            return null;
        }
        return matchStorage.usersLiked(user);
    }

    public void addLike(int idUser, int idUserLiked) {
        User user = userManagement.search(idUser);
        User userLiked = userManagement.search(idUserLiked);

        //check null
        checkUsers(user, userLiked);

        //add like
        matchStorage.addLike(user, userLiked);

        //check matches
        checkAfterLike(user, userLiked);
    }

    public void deleteLike(int idUser, int idUserNotLiked) {
        User user = userManagement.search(idUser);
        User userNotLiked = userManagement.search(idUserNotLiked);

        //check null
        checkUsers(user, userNotLiked);

        //delete like
        matchStorage.deleteLike(user, userNotLiked);

        //check unmatch
        checkAfterDeleteLike(user, userNotLiked);
    }

    //dislikes
    public List<User> usersDisliked(int id) {
        User user = userManagement.search(id);
        if (user == null) {
            return null;
        }
        return matchStorage.usersDisliked(user);
    }

    public void addDislike(int idUser, int idUserDisliked) {
        User user = userManagement.search(idUser);
        User userDisliked = userManagement.search(idUserDisliked);

        checkUsers(user, userDisliked);

        matchStorage.addDislike(user, userDisliked);
    }

    public void deleteDislike(int idUser, int idUserNotDisliked) {
        User user = userManagement.search(idUser);
        User userNotDisliked = userManagement.search(idUserNotDisliked);

        checkUsers(user, userNotDisliked);

        matchStorage.deleteDislike(user, userNotDisliked);
    }

    //matches
    public List<User> matchesList(int id) {
        User user = userManagement.search(id);
        if (user == null) {
            throw new RuntimeException("Usuário(s) não encontrado(s).");
        }
        return matchStorage.matchesList(user);
    }

    public void checkAfterLike(User user, User userLiked) {
        if (userLiked.likes().contains(user)) {
            matchStorage.addMatchBetween(user, userLiked);
        }
    }

    public void checkAfterDeleteLike(User user, User userNotLiked) {
        if (userNotLiked.matches().contains(user)) {
            matchStorage.deleteMatchBetween(user, userNotLiked);
        }
    }

}
