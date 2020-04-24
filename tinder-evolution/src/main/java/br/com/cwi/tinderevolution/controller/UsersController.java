package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.series.Series;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/users")
public class UsersController {

    @Autowired
    private UserManagement management;

    @GetMapping
    private List<User> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private User search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody User user) {
        management.create(user);
    }

    @PutMapping("{id}")
    private User edit(@PathVariable int id, @RequestBody User user) {
        return management.edit(id, user);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get lists by user id

    @GetMapping("{id}/musics")
    public List<Music> musics(@PathVariable("id") int id) {
        return management.musicsLiked(id);
    }

    @GetMapping("{id}/movies")
    public List<Movie> movies(@PathVariable("id") int id) {
        return management.moviesLiked(id);
    }

    @GetMapping("{id}/series")
    public List<Series> series(@PathVariable("id") int id) {
        return management.seriesLiked(id);
    }

    @GetMapping("{id}/games")
    public List<Game> games(@PathVariable("id") int id) {
        return management.gamesLiked(id);
    }

    @GetMapping("{id}/sports")
    public List<Sport> sports(@PathVariable("id") int id) {
        return management.sportsLiked(id);
    }

    @GetMapping("{id}/curiosities")
    public List<Curiosity> curiosities(@PathVariable("id") int id) {
        return management.curiositiesSet(id);
    }

}




