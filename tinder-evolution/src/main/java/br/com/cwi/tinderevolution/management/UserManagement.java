package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.UserStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class UserManagement {

    private final UserStorage storage = new UserStorage();

    public void checkExistent(User user) {
        // existent rule
        for (User usersExistent : list()) {
            if (user.getEmail().equals(usersExistent.getEmail())) {
                throw new RuntimeException("E-mail já cadastrado no sistema.");
            }
        }
    }

    public void checkRules(User user) {
        // attribute rules
        if (user.getName().isEmpty() || user.getEmail().isEmpty() ||
                user.getPhone().isEmpty() || user.getBirthDate() == null ||
                user.getBio().isEmpty() || user.getLatitude() == null || user.getLongitude() == null) {
            throw new RuntimeException("Algum atributo não preenchido.");
        }

        if (Period.between(user.getBirthDate(), LocalDate.now()).getYears() < 18) {
            throw new RuntimeException("Usuário menor de 18 anos.");
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

    public User create(User user) {
        checkExistent(user);
        checkRules(user);

        user.setId(checkId());
        return storage.create(user);
    }

    public List<User> list() {
        return storage.list();
    }

    public User edit(int id, User userUpdated) {

        User userToEdit = search(id);

        //check existent rule only if the e-mail is different, because otherwise, you wouldn't get to edit other attributes while keeping the same e-mail
        if (!userToEdit.getEmail().equals(userUpdated.getEmail())) {
            checkExistent(userUpdated);
        }

        //check attributes error
        checkRules(userUpdated);

        return storage.edit(userToEdit, userUpdated);
    }

    public User search(int id) {
        //first, it checks to a valid input, and then looks into "database"
        if (id > 0) {
            User user = storage.search(id);
            if (user == null) {
                throw new RuntimeException("Usuário não encontrado.");
            }
            return user;
        }
        throw new RuntimeException("Id inválido.");
    }

    public boolean delete(int id) {
        User user = search(id);
        return storage.delete(user);
    }

    //get "things" liked by user id
    public List<Music> musicsLiked(int id) {
        User user = search(id);
        return storage.musicsLiked(user);
    }

    public List<Movie> moviesLiked(int id) {
        User user = search(id);
        return storage.moviesLiked(user);
    }

    public List<Series> seriesLiked(int id) {
        User user = search(id);
        return storage.seriesLiked(user);
    }

    public List<Game> gamesLiked(int id) {
        User user = search(id);
        return storage.gamesLiked(user);
    }

    public List<Sport> sportsLiked(int id) {
        User user = search(id);
        return storage.sportsLiked(user);
    }

    public List<Curiosity> curiositiesSet(int id) {
        User user = search(id);
        return storage.curiositiesSet(user);
    }

}
