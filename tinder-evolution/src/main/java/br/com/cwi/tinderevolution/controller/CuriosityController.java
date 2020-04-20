package br.com.cwi.tinderevolution.controller;


import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.CuriosityManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/curiosities")
public class CuriosityController {

    @Autowired
    private CuriosityManagement management;

    @GetMapping
    private List<Curiosity> list() {
        return management.list();
    }

    @GetMapping("/{id}")
    private Curiosity search(@PathVariable("id") int id) {
        return management.search(id);
    }

    @PostMapping
    private void create(@RequestBody Curiosity music) {
        management.create(music);
    }

    @PutMapping("{id}")
    private Curiosity edit(@PathVariable int id, @RequestBody Curiosity music) {
        return management.edit(id, music);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get users by curiosity id
    @GetMapping("{id}/users")
    public List<User> getUsers(@PathVariable("id") int id){
        return management.getUsers(id);
    }


}

