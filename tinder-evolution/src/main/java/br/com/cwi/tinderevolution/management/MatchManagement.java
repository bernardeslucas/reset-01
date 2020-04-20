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

import java.util.ArrayList;
import java.util.Iterator;
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
        checkMatch(user, userLiked);
    }

    public void deleteLike(int idUser, int idUserNotLiked) {
        User user = userManagement.search(idUser);
        User userNotLiked = userManagement.search(idUserNotLiked);

        //check null
        checkUsers(user, userNotLiked);

        //delete like
        matchStorage.deleteLike(user, userNotLiked);

        //check unmatch
        checkUnmatch(user, userNotLiked);
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

        //check user existence
        checkUsers(user, userDisliked);

        //add dislike
        matchStorage.addDislike(user, userDisliked);

        //check unmatch
        checkUnmatch(user, userDisliked);

    }

    public void deleteDislike(int idUser, int idUserNotDisliked) {
        User user = userManagement.search(idUser);
        User userNotDisliked = userManagement.search(idUserNotDisliked);

        //check null
        checkUsers(user, userNotDisliked);

        //delete dislike
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

    //best
    public List<User> best(int id) {
        User user = userManagement.search(id);
        List<User> userBest = new ArrayList<>();
        int counter = 0;
        int counterBest = 0;

        for (Iterator<User> i = userManagement.list().iterator(); i.hasNext(); ) {
            User userIterated = i.next();

            if (userIterated == user || user.matches().contains(userIterated) || user.dislikes().contains(userIterated) ||
                    userIterated.dislikes().contains(user)) {
                continue;
            }
            //retrieve the listsLiked from the user iterated
            List<Music> musicsCommon = userIterated.getMusicsLiked();
            List<Series> seriesCommon = userIterated.getSeriesLiked();
            List<Movie> moviesCommon = userIterated.getMoviesLiked();
            List<Game> gamesCommon = userIterated.getGamesLiked();
            List<Sport> sportsCommon = userIterated.getSportsLiked();
            List<Curiosity> curiositiesCommon = userIterated.getCuriositiesSet();

            //retain only the common items to use the size list
            musicsCommon.retainAll(user.getMusicsLiked());
            seriesCommon.retainAll(user.getSeriesLiked());
            moviesCommon.retainAll(user.getMoviesLiked());
            gamesCommon.retainAll(user.getGamesLiked());
            sportsCommon.retainAll(user.getSportsLiked());
            curiositiesCommon.retainAll(user.getCuriositiesSet());

            //count items in common
            counter = musicsCommon.size() + seriesCommon.size() + moviesCommon.size() + gamesCommon.size() + sportsCommon.size() + curiositiesCommon.size();

            //checks the best, if there are two identical best
            if (counter == counterBest) {
                userBest.add(userIterated);
            } else if (counter > counterBest) {
                counterBest = counter;
                userBest.clear();
                userBest.add(userIterated);
            }

        }

        return userBest;
    }

}
