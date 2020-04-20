package br.com.cwi.tinderevolution.management;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.storage.LikesStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesManagement {

    private LikesStorage likeStorage = new LikesStorage();
    private UserManagement userManagement = new UserManagement();
    private MusicManagement musicManagement = new MusicManagement();
    private MovieManagement movieManagement = new MovieManagement();
    private SeriesManagement seriesManagement = new SeriesManagement();
    private GameManagement gameManagement = new GameManagement();
    private SportManagement sportManagement = new SportManagement();
    private CuriosityManagement curiosityManagement = new CuriosityManagement();

    //musics
    public List<Music> musicsLiked(int id) {
        User user = userManagement.search(id);
        if (user == null) {
            return null;
        }
        return likeStorage.musicsLiked(user);
    }

    public void likeMusic(int idUser, int idMusic) {
        User user = userManagement.search(idUser);
        Music music = musicManagement.search(idMusic);
        if (user == null || music == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }

        music.addUsers(user);
        likeStorage.likeMusic(user, music);
    }

    public void dislikeMusic(int idUser, int idMusic) {
        User user = userManagement.search(idUser);
        Music music = musicManagement.search(idMusic);
        if (user == null || music == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }
        if (!user.getMusicsLiked().contains(music)) {
            throw new RuntimeException("Música não curtida pelo usuário.");
        }
        music.deleteUsers(user);
        likeStorage.dislikeMusic(user, music);

    }

    //movies
    public void likeMovie(int idUser, int idMovie) {
        User user = userManagement.search(idUser);
        Movie movie = movieManagement.search(idMovie);
        if (user == null || movie == null) {
            throw new RuntimeException("Usuário e/ou filme não encontrados no sistema.");
        }

        movie.addUser(user);
        likeStorage.likeMovie(user, movie);
    }

    public void dislikeMovie(int idUser, int idMovie) {
        User user = userManagement.search(idUser);
        Movie movie = movieManagement.search(idMovie);
        if (user == null || movie == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }
        if (!user.getMoviesLiked().contains(movie)) {
            throw new RuntimeException("Filme não curtido pelo usuário.");
        }
        movie.removeUser(user);
        likeStorage.dislikeMovie(user, movie);
    }

    //series
    public void likeSeries(int idUser, int idSeries) {
        User user = userManagement.search(idUser);
        Series series = seriesManagement.search(idSeries);
        if (user == null || series == null) {
            throw new RuntimeException("Usuário e/ou série não encontrados no sistema.");
        }

        series.addUser(user);
        likeStorage.likeSeries(user, series);
    }

    public void dislikeSeries(int idUser, int idSeries) {
        User user = userManagement.search(idUser);
        Series series = seriesManagement.search(idSeries);
        if (user == null || series == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }
        if (!user.getSeriesLiked().contains(series)) {
            throw new RuntimeException("Série não curtida pelo usuário.");
        }

        series.removeUser(user);
        likeStorage.dislikeSeries(user, series);
    }

    //game
    public void likeGame(int idUser, int idGame) {
        User user = userManagement.search(idUser);
        Game game = gameManagement.search(idGame);
        if (user == null || game == null) {
            throw new RuntimeException("Usuário e/ou jogo não encontrados no sistema.");
        }

        game.addUser(user);
        likeStorage.likeGame(user, game);
    }

    public void dislikeGame(int idUser, int idGame) {
        User user = userManagement.search(idUser);
        Game game = gameManagement.search(idGame);
        if (user == null || game == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }
        if (!user.getGamesLiked().contains(game)) {
            throw new RuntimeException("Jogo não curtido pelo usuário.");
        }
        game.removeUser(user);
        likeStorage.dislikeGame(user, game);
    }

    //sport
    public void likeSport(int idUser, int idSport) {
        User user = userManagement.search(idUser);
        Sport sport = sportManagement.search(idSport);
        if (user == null || sport == null) {
            throw new RuntimeException("Usuário e/ou esporte não encontrados no sistema.");
        }
        sport.addUser(user);
        likeStorage.likeSport(user, sport);
    }

    public void dislikeSport(int idUser, int idSport) {
        User user = userManagement.search(idUser);
        Sport sport = sportManagement.search(idSport);
        if (user == null || sport == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }
        if (!user.getSportsLiked().contains(sport)) {
            throw new RuntimeException("Esporte não curtido pelo usuário.");
        }
        sport.removeUser(user);
        likeStorage.dislikeSport(user, sport);
    }

    //curiosity
    public void likeCuriosity(int idUser, int idCuriosity) {
        User user = userManagement.search(idUser);
        Curiosity curiosity = curiosityManagement.search(idCuriosity);
        if (user == null || curiosity == null) {
            throw new RuntimeException("Usuário e/ou curiosidade não encontrados no sistema.");
        }
        curiosity.addUser(user);
        likeStorage.addCuriosity(user, curiosity);
    }

    public void dislikeCuriosity(int idUser, int idCuriosity) {
        User user = userManagement.search(idUser);
        Curiosity curiosity = curiosityManagement.search(idCuriosity);
        if (user == null || curiosity == null) {
            throw new RuntimeException("Usuário e/ou música não encontrados no sistema.");
        }
        if (!user.getCuriositiesSet().contains(curiosity)) {
            throw new RuntimeException("Curiosidade não cadastrada nesse usuário.");
        }
        curiosity.removeUser(user);
        likeStorage.deleteCuriosity(user, curiosity);
    }

}
