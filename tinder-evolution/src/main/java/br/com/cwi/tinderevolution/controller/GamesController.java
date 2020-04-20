package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.game.Game;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.GameManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/games")
public class GamesController {

    @Autowired
    private GameManagement management;

    @GetMapping
    private List<Game> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private Game search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody Game music) {
        management.create(music);
    }

    @PutMapping("{id}")
    private Game edit(@PathVariable int id, @RequestBody Game music) {
        return management.edit(id, music);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get users by games id
    @GetMapping("{id}/users")
    public List<User> getUsers(@PathVariable("id") int id){
        return management.getUsers(id);
    }
}

