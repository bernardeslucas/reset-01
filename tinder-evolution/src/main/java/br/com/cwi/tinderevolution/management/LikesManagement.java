package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.LikeStorage;
import org.springframework.stereotype.Service;

@Service
public class LikesManagement {

    private final LikeStorage likeStorage = new LikeStorage();
    private final UserManagement userManagement = new UserManagement();
    private final MusicManagement musicManagement = new MusicManagement();
    private final MovieManagement movieManagement = new MovieManagement();
    private final SeriesManagement seriesManagement = new SeriesManagement();
    private final GameManagement gameManagement = new GameManagement();
    private final SportManagement sportManagement = new SportManagement();
    private final CuriosityManagement curiosityManagement = new CuriosityManagement();

    public boolean checkLike(User user, Object object) {
        if (user.getMusicsLiked().contains(object) ||
                user.getMoviesLiked().contains(object) ||
                user.getSeriesLiked().contains(object) ||
                user.getGamesLiked().contains(object) ||
                user.getSportsLiked().contains(object) ||
                user.getCuriositiesSet().contains(object)) {
            return true;
        }
        return false;
    }

    //musics

    public void likeMusic(int idUser, int idMusic) {
        User user = userManagement.search(idUser);
        Music music = musicManagement.search(idMusic);

        if (checkLike(user, music)) {
            throw new RuntimeException("Essa música já foi curtida pelo usuário.");
        }
        music.addUsers(user);
        likeStorage.likeMusic(user, music);
    }

    public void dislikeMusic(int idUser, int idMusic) {
        User user = userManagement.search(idUser);
        Music music = musicManagement.search(idMusic);

        if (!checkLike(user, music)) {
            throw new RuntimeException("Música não curtida pelo usuário.");
        }
        music.deleteUsers(user);
        likeStorage.dislikeMusic(user, music);

    }

    //movies
    public void likeMovie(int idUser, int idMovie) {
        User user = userManagement.search(idUser);
        Movie movie = movieManagement.search(idMovie);

        if (checkLike(user, movie)) {
            throw new RuntimeException("Esse filme já foi curtido pelo usuário.");
        }
        movie.addUser(user);
        likeStorage.likeMovie(user, movie);
    }

    public void dislikeMovie(int idUser, int idMovie) {
        User user = userManagement.search(idUser);
        Movie movie = movieManagement.search(idMovie);

        if (!checkLike(user, movie)) {
            throw new RuntimeException("Filme não curtido pelo usuário.");
        }
        movie.removeUser(user);
        likeStorage.dislikeMovie(user, movie);
    }

    //series
    public void likeSeries(int idUser, int idSeries) {
        User user = userManagement.search(idUser);
        Series series = seriesManagement.search(idSeries);
        if (checkLike(user, series)) {
            throw new RuntimeException("Essa série já foi curtida pelo usuário.");
        }
        series.addUser(user);
        likeStorage.likeSeries(user, series);
    }

    public void dislikeSeries(int idUser, int idSeries) {
        User user = userManagement.search(idUser);
        Series series = seriesManagement.search(idSeries);

        if (!checkLike(user, series)) {
            throw new RuntimeException("Série não curtida pelo usuário.");
        }

        series.removeUser(user);
        likeStorage.dislikeSeries(user, series);
    }

    //game
    public void likeGame(int idUser, int idGame) {
        User user = userManagement.search(idUser);
        Game game = gameManagement.search(idGame);
        if (checkLike(user, game)) {
            throw new RuntimeException("Esse jogo já foi curtido pelo usuário.");
        }
        game.addUser(user);
        likeStorage.likeGame(user, game);
    }

    public void dislikeGame(int idUser, int idGame) {
        User user = userManagement.search(idUser);
        Game game = gameManagement.search(idGame);

        if (!checkLike(user, game)) {
            throw new RuntimeException("Jogo não curtido pelo usuário.");
        }
        game.removeUser(user);
        likeStorage.dislikeGame(user, game);
    }

    //sport
    public void likeSport(int idUser, int idSport) {
        User user = userManagement.search(idUser);
        Sport sport = sportManagement.search(idSport);

        if (checkLike(user, sport)) {
            throw new RuntimeException("Esse esporte já foi curtido pelo usuário.");
        }
        sport.addUser(user);
        likeStorage.likeSport(user, sport);
    }

    public void dislikeSport(int idUser, int idSport) {
        User user = userManagement.search(idUser);
        Sport sport = sportManagement.search(idSport);

        if (!checkLike(user, sport)) {
            throw new RuntimeException("Esporte não curtido pelo usuário.");
        }
        sport.removeUser(user);
        likeStorage.dislikeSport(user, sport);
    }

    //curiosity
    public void likeCuriosity(int idUser, int idCuriosity) {
        User user = userManagement.search(idUser);
        Curiosity curiosity = curiosityManagement.search(idCuriosity);

        if (checkLike(user, curiosity)) {
            throw new RuntimeException("Essa curiosidade já foi definida pelo usuário.");
        }
        curiosity.addUser(user);
        likeStorage.addCuriosity(user, curiosity);
    }

    public void dislikeCuriosity(int idUser, int idCuriosity) {
        User user = userManagement.search(idUser);
        Curiosity curiosity = curiosityManagement.search(idCuriosity);

        if (!checkLike(user, curiosity)) {
            throw new RuntimeException("Curiosidade não cadastrada nesse usuário.");
        }
        curiosity.removeUser(user);
        likeStorage.deleteCuriosity(user, curiosity);
    }

}
