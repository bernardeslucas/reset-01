package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchStorage {

    //likes
    public List<User> usersLiked(User user) {
        return user.likes();
    }

    public void addLike(User user, User userLiked) {
        user.addLike(userLiked);
    }

    public void deleteLike(User user, User userNotLiked) {
        user.deleteLike(userNotLiked);
    }

    //dislikes
    public List<User> usersDisliked(User user) {
        return user.dislikes();
    }

    public void addDislike(User user, User userDisliked) {
        user.addDislike(userDisliked);
    }

    public void deleteDislike(User user, User userNotDisliked) {
        user.deleteDislike(userNotDisliked);
    }

    //matches
    public List<User> matchesList (User user){
        return user.matches();
    }

    public void addMatchBetween(User user1, User user2) {
        user1.addMatch(user2);
        user2.addMatch(user1);
    }

    public void deleteMatchBetween(User user1, User user2){
        user1.deleteMatch(user2);
        user2.deleteMatch(user1);
    }

}
