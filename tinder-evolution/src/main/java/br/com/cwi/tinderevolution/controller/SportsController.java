package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.SportManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/sports")
public class SportsController {

    @Autowired
    private SportManagement management;

    @GetMapping
    private List<Sport> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private Sport search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody Sport sport) {
        management.create(sport);
    }

    @PutMapping("{id}")
    private Sport edit(@PathVariable int id, @RequestBody Sport sport) {
        return management.edit(id, sport);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get users by sport id
    @GetMapping("{id}/users")
    public List<User> getUsers(@PathVariable("id") int id){
        return management.getUsers(id);
    }
}

