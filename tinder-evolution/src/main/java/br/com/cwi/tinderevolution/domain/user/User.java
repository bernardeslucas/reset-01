package br.com.cwi.tinderevolution.domain.user;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String bio;
    private Double latitude = null, longitude = null;
    private String photoUrl;

    private List<Music> musicsLiked = new ArrayList<>();
    private List<Movie> moviesLiked = new ArrayList<>();
    private List<Series> seriesLiked = new ArrayList<>();
    private List<Game> gamesLiked = new ArrayList<>();
    private List<Sport> sportsLiked = new ArrayList<>();
    private List<Curiosity> curiositiesDefined = new ArrayList<>();

    private List<User> likes = new ArrayList<>();
    private List<User> dislikes = new ArrayList<>();
    private List<User> matches = new ArrayList<>();
    private User best;

    public User(int id, String name, String email, String phone, LocalDate birthDate, String bio, Double latitude, Double longitude, String photoUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.bio = bio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    //to do: return photo preview
    public String photoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    //musics
    public List<Music> getMusicsLiked() {
        return musicsLiked;
    }

    public void likeMusic(Music music) {
        musicsLiked.add(music);
    }

    public void dislikeMusic(Music music) {
        musicsLiked.remove(music);
    }

    //movies

    public List<Movie> getMoviesLiked() {
        return moviesLiked;
    }

    public void likeMovie(Movie movie) {
        moviesLiked.add(movie);
    }

    public void dislikeMovie(Movie movie) {
        moviesLiked.remove(movie);
    }

    //series
    public List<Series> getSeriesLiked() {
        return seriesLiked;
    }

    public void likeSeries(Series series) {
        seriesLiked.add(series);
    }

    public void dislikeSeries(Series series) {
        seriesLiked.remove(series);
    }

    //game
    public List<Game> getGamesLiked() {
        return gamesLiked;
    }

    public void likeGame(Game game) {
        gamesLiked.add(game);
    }

    public void dislikeGame(Game game) {
        gamesLiked.remove(game);
    }

    //sport
    public List<Sport> getSportsLiked() {
        return sportsLiked;
    }

    public void likeSport(Sport sport) {
        sportsLiked.add(sport);
    }

    public void dislikeSport(Sport sport) {
        sportsLiked.remove(sport);
    }

    //curiosity
    public List<Curiosity> getCuriositiesSet() {
        return curiositiesDefined;
    }

    public void addCuriosity(Curiosity curiosity) {
        curiositiesDefined.add(curiosity);
    }

    public void deleteCuriosity(Curiosity curiosity) {
        curiositiesDefined.remove(curiosity);
    }

    //likes
    public List<User> likes() {
        return likes;
    }

    public void addLike(User user) {
        likes.add(user);
    }

    public void deleteLike(User user) {
        likes.remove(user);
    }

    //dislikes
    public List<User> dislikes() {
        return dislikes;
    }

    public void addDislike(User user) {
        dislikes.add(user);
    }

    public void deleteDislike(User user) {
        dislikes.remove(user);
    }

    //matches
    public List<User> matches() {
        return matches;
    }

    public void addMatch(User user) {
        matches.add(user);
    }

    public void deleteMatch(User user) {
        matches.remove(user);
    }

    //best
    public User best() {
        return best;
    }

    public void setBest(User best) {
        this.best = best;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", bio='" + bio + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
