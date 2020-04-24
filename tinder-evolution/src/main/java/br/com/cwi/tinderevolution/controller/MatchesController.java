package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.MatchManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinder/api/matches")
public class MatchesController {

    @Autowired
    private MatchManagement management;

    //likes
    @GetMapping("/user/{id}/likes")
    public List<User> likes (@PathVariable("id") int id){
        return management.usersLiked(id);
    }

    @PostMapping("/{idUserLiked}/user/{idUser}/like")
    public void addLike(@PathVariable("idUser") int idUser, @PathVariable("idUserLiked") int idUserLiked) {
        management.addLike(idUser, idUserLiked);
    }

    @DeleteMapping("/{idUserLiked}/user/{idUser}/like")
    public void deleteLike(@PathVariable("idUser") int idUser, @PathVariable("idUserLiked") int idUserLiked) {
        management.deleteLike(idUser, idUserLiked);
    }

    //dislikes
    @GetMapping("/user/{id}/dislikes")
    public List<User> dislikes (@PathVariable("id") int id){
        return management.usersDisliked(id);
    }

    @PostMapping("/{idUserDisliked}/user/{idUser}/dislike")
    public void addDislike(@PathVariable("idUser") int idUser, @PathVariable("idUserDisliked") int idUserDisliked) {
        management.addDislike(idUser, idUserDisliked);
    }

    @DeleteMapping("/{idUserDisliked}/user/{idUser}/dislike")
    public void deleteDislike(@PathVariable("idUser") int idUser, @PathVariable("idUserDisliked") int idUserDisliked) {
        management.deleteDislike(idUser, idUserDisliked);
    }

    //matches
    @GetMapping("/{id}")
    public List<User> matchesList(@PathVariable("id") int id) {
        return management.matchesList(id);
    }

    //get nearest best possible match within 10km
    @GetMapping("/{id}/best")
    public User best(@PathVariable("id") int id) {
        return management.best(id);
    }


}
