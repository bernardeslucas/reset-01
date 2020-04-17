package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.MatchManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/matches")
public class MatchController {

    @Autowired
    private MatchManagement management;

    //likes
    @PostMapping("/{idUser}/user/{idUserLiked}/like")
    public void addLike(@PathVariable("idUser") int idUser, @PathVariable("idUserLiked") int idUserLiked) {
        management.addLike(idUser, idUserLiked);
    }

    @DeleteMapping("/{idUser}/user/{idUserLiked}/like")
    public void deleteLike(@PathVariable("idUser") int idUser, @PathVariable("idUserLiked") int idUserLiked) {
        management.deleteLike(idUser, idUserLiked);
    }

    //matches
    @GetMapping("/{id}")
    public List<User> matchesList(@PathVariable("id") int id) {
        return management.matchesList(id);
    }

}
