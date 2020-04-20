package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.music.MusicGenres;
import br.com.cwi.tinderevolution.domain.sport.Sport;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.MatchManagement;
import br.com.cwi.tinderevolution.management.MusicManagement;
import br.com.cwi.tinderevolution.management.SportManagement;
import br.com.cwi.tinderevolution.management.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tinder/api/matches")
public class MatchController {

    @Autowired
    private MatchManagement management;



    //likes
    @PostMapping("/{idUserLiked}/user/{idUser}/like")
    public void addLike(@PathVariable("idUser") int idUser, @PathVariable("idUserLiked") int idUserLiked) {
        management.addLike(idUser, idUserLiked);
    }

    @DeleteMapping("/{idUserLiked}/user/{idUser}/like")
    public void deleteLike(@PathVariable("idUser") int idUser, @PathVariable("idUserLiked") int idUserLiked) {
        management.deleteLike(idUser, idUserLiked);
    }

    //dislikes
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

    @GetMapping("/{id}/best")
    public List<User> best(@PathVariable("id") int id){












        return management.best(id);
    }

}
