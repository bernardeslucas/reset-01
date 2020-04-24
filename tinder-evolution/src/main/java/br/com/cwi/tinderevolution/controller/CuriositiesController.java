package br.com.cwi.tinderevolution.controller;


import br.com.cwi.tinderevolution.domain.curiosity.Curiosity;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.domain.user.UserDTO;
import br.com.cwi.tinderevolution.management.CuriosityManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/curiosities")
public class CuriositiesController {

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
    private void create(@RequestBody Curiosity curiosity) {
        management.create(curiosity);
    }

    @PutMapping("{id}")
    private Curiosity edit(@PathVariable int id, @RequestBody Curiosity curiosity) {
        return management.edit(id, curiosity);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable int id) {
        management.delete(id);
    }

    //get users by curiosity id
    @GetMapping("{id}/users")
    public List<UserDTO> getUsers(@PathVariable("id") int id){
        //created a UserDTO class to handle the JSON serialization as necessary
        return management.getUsers(id);
    }


}

