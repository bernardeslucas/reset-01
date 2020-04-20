package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
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
        userToEdit.setPhotoUrl(userUpdated.getPhotoUrl());

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

    public boolean delete(User userToDelete) {

        users.remove(userToDelete);

        return true;

    }

    public List<Music> musicsLiked(User user) {
        return user.getMusicsLiked();
    }

    public List<Movie> moviesLiked(User user) {
        return user.getMoviesLiked();
    }

    public List<Series> seriesLiked(User user) {
        return user.getSeriesLiked();
    }

    public List<Sport> sportsLiked(User user) {
        return user.getSportsLiked();
    }

    public List<Game> gamesLiked(User user) {
        return user.getGamesLiked();
    }

    public List<Curiosity> curiositiesSet(User user) {
        return user.getCuriositiesSet();
    }

}
