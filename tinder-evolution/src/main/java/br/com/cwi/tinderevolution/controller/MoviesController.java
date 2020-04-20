package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.movie.Movie;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.MovieManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/movies")
public class MoviesController {

    @Autowired
    private MovieManagement management;

    @GetMapping
    private List<Movie> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private Movie search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody Movie music) {
        management.create(music);
    }

    @PutMapping("{id}")
    private Movie edit(@PathVariable int id, @RequestBody Movie music) {
        return management.edit(id, music);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get users by movies id
    @GetMapping("{id}/users")
    public List<User> usersLikes(@PathVariable("id") int id){
        return management.getUsers(id);
    }
}
