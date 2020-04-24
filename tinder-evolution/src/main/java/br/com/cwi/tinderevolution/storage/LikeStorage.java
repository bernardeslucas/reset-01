package br.com.cwi.tinderevolution.storage;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class LikeStorage {

    //music
    public void likeMusic(User user, Music music) {
        user.likeMusic(music);
    }

    public void dislikeMusic(User user, Music music) {
        user.dislikeMusic(music);
    }

    //movie
    public void likeMovie(User user, Movie movie) {
        user.likeMovie(movie);
    }

    public void dislikeMovie(User user, Movie movie) {
        user.dislikeMovie(movie);
    }

    //series
    public void likeSeries(User user, Series series) {
        user.likeSeries(series);
    }

    public void dislikeSeries(User user, Series series) {
        user.dislikeSeries(series);
    }

    //game
    public void likeGame(User user, Game game) {
        user.likeGame(game);
    }

    public void dislikeGame(User user, Game game) {
        user.dislikeGame(game);
    }

    //sport
    public void likeSport(User user, Sport music) {
        user.likeSport(music);
    }

    public void dislikeSport(User user, Sport music) {
        user.dislikeSport(music);
    }

    //curiosity
    public void addCuriosity(User user, Curiosity curiosity) {
        user.addCuriosity(curiosity);
    }

    public void deleteCuriosity(User user, Curiosity curiosity) {
        user.deleteCuriosity(curiosity);
    }

}
