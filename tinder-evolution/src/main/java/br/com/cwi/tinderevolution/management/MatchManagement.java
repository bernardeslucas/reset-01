package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.MatchStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchManagement {
    private final MatchStorage matchStorage = new MatchStorage();
    private final UserManagement userManagement = new UserManagement();



    public void checkMatch(User user, User userLiked) {
        if (userLiked.likes().contains(user) && !userLiked.matches().contains(user)) {
            matchStorage.addMatchBetween(user, userLiked);
        } else if (userLiked.matches().contains(user)) {
            throw new RuntimeException("Usuários já possuem um match entre si.");
        }
    }

    public void checkUnmatch(User user, User userNotLiked) {
        if (userNotLiked.matches().contains(user)) {
            matchStorage.deleteMatchBetween(user, userNotLiked);
        }
    }

    //likes
    public List<User> usersLiked(int id) {
        User user = userManagement.search(id);
        return matchStorage.usersLiked(user);
    }

    public void addLike(int idUser, int idUserLiked) {
        User user = userManagement.search(idUser);
        User userLiked = userManagement.search(idUserLiked);

        //check if already liked
        if(user.likes().contains(userLiked)){
            throw new RuntimeException("Usuário já deu like neste usário.");
        }

        //add like
        matchStorage.addLike(user, userLiked);

        //check matches
        checkMatch(user, userLiked);
    }

    public void deleteLike(int idUser, int idUserNotLiked) {
        User user = userManagement.search(idUser);
        User userNotLiked = userManagement.search(idUserNotLiked);

        //check if liked
        if(!user.likes().contains(userNotLiked)){
            throw new RuntimeException("Usuário não havia dado like neste usuário.");
        }

        //delete like
        matchStorage.deleteLike(user, userNotLiked);

        //check unmatch
        checkUnmatch(user, userNotLiked);
    }

    //dislikes
    public List<User> usersDisliked(int id) {
        User user = userManagement.search(id);
        return matchStorage.usersDisliked(user);
    }

    public void addDislike(int idUser, int idUserDisliked) {
        User user = userManagement.search(idUser);
        User userDisliked = userManagement.search(idUserDisliked);

        //check if already disliked
        if(user.dislikes().contains(userDisliked)){
            throw new RuntimeException("Usuário já deu dislike neste usário.");
        }

        //add dislike
        matchStorage.addDislike(user, userDisliked);

        //check unmatch
        checkUnmatch(user, userDisliked);

    }

    public void deleteDislike(int idUser, int idUserNotDisliked) {
        User user = userManagement.search(idUser);
        User userNotDisliked = userManagement.search(idUserNotDisliked);

        //check if disliked
        if(!user.dislikes().contains(userNotDisliked)){
            throw new RuntimeException("Usuário não havia dado dislike neste usário.");
        }

        //delete dislike
        matchStorage.deleteDislike(user, userNotDisliked);
    }

    //matches
    public List<User> matchesList(int id) {
        User user = userManagement.search(id);

        return matchStorage.matchesList(user);
    }

    //distance between two users
    public double distanceBetween(User user1, User user2) {

        double lat1 = user1.getLatitude();
        double long1 = user1.getLongitude();
        double lat2 = user2.getLatitude();
        double long2 = user2.getLongitude();

        //math calculation between two geo coordinates - in km
        return org.apache.lucene.util.SloppyMath.haversinMeters(lat1, long1, lat2, long2) / 1000;
    }

    //get the nearest best possible match within 10km
    public User best(int id) {
        User user = userManagement.search(id);
        User best = null;
//        List<User> userBest = new ArrayList<>();

        int counter;
        int counterBest = 0;

        for (User userIterated : userManagement.list()) {
            if (userIterated == user || user.matches().contains(userIterated) || user.dislikes().contains(userIterated) ||
                    userIterated.dislikes().contains(user) || distanceBetween(user, userIterated) > 10) {
                continue;
            }
            //retrieve the likedLists from the user iterated
            List<Music> musicsCommon = userIterated.getMusicsLiked();
            List<Series> seriesCommon = userIterated.getSeriesLiked();
            List<Movie> moviesCommon = userIterated.getMoviesLiked();
            List<Game> gamesCommon = userIterated.getGamesLiked();
            List<Sport> sportsCommon = userIterated.getSportsLiked();
            List<Curiosity> curiositiesCommon = userIterated.getCuriositiesSet();

            //retain only the common items between user and userIterated to use the size list as a counter of common items
            musicsCommon.retainAll(user.getMusicsLiked());
            seriesCommon.retainAll(user.getSeriesLiked());
            moviesCommon.retainAll(user.getMoviesLiked());
            gamesCommon.retainAll(user.getGamesLiked());
            sportsCommon.retainAll(user.getSportsLiked());
            curiositiesCommon.retainAll(user.getCuriositiesSet());

            //count items in common
            counter = musicsCommon.size() + seriesCommon.size() + moviesCommon.size() + gamesCommon.size() + sportsCommon.size() + curiositiesCommon.size();

            //checks the best(s) within 10km (not caring about nearest)
            //-> could return more than one if they have the same number of common items between each other
            //to test this alternative, the method has to return a List<User>
//            if (counter == counterBest) {
//                userBest.add(userIterated);
//            } else if (counter > counterBest) {
//                counterBest = counter;
//                userBest.clear();
//                userBest.add(userIterated);
//            }

            // -> confirm that the best has at least 1 item in common and to avoid the distanceBetween(user, null)
            if (counter == 0) {
                continue;
            }
            //check the current best
            if (counter > counterBest || counter == counterBest && distanceBetween(user, userIterated) < distanceBetween(user, best)) {
                counterBest = counter;
                best = userIterated;
            }

        }
        return best;
    }

}
