package br.com.cwi.tinderevolution.controller;

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
}




