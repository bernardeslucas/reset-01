package br.com.cwi.tinderevolution.controller;

import br.com.cwi.tinderevolution.management.LikesManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tinder/api/likes")
public class LikesController {

    @Autowired
    private LikesManagement management;

    //musics
    @PostMapping("/music/{idMusic}/user/{idUser}")
    private void likeMusic(@PathVariable("idMusic") int idMusic, @PathVariable("idUser") int idUser) {
        management.likeMusic(idUser, idMusic);
    }

    @DeleteMapping("/music/{idMusic}/user/{idUser}")
    private void dislikeMusic(@PathVariable("idMusic") int idMusic, @PathVariable("idUser") int idUser) {
        management.dislikeMusic(idUser, idMusic);
    }
    //movies
    @PostMapping("/movie/{idMovie}/user/{idUser}")
    private void likeMovie(@PathVariable("idMovie") int idMovie, @PathVariable("idUser") int idUser) {
        management.likeMovie(idUser, idMovie);
    }

    @DeleteMapping("/movie/{idMovie}/user/{idUser}")
    private void dislikeMovie(@PathVariable("idMovie") int idMovie, @PathVariable("idUser") int idUser) {
        management.dislikeMovie(idUser, idMovie);
    }

    //series
    @PostMapping("/series/{idSeries}/user/{idUser}")
    private void likeSeries(@PathVariable("idSeries") int idSeries, @PathVariable("idUser") int idUser) {
        management.likeSeries(idUser, idSeries);
    }

    @DeleteMapping("/series/{idSeries}/user/{idUser}")
    private void dislikeSeries(@PathVariable("idSeries") int idSeries, @PathVariable("idUser") int idUser) {
        management.dislikeSeries(idUser, idSeries);
    }

    //game
    @PostMapping("/game/{idGame}/user/{idUser}")
    private void likeGame(@PathVariable("idGame") int idGame, @PathVariable("idUser") int idUser) {
        management.likeGame(idUser, idGame);
    }

    @DeleteMapping("/game/{idGame}/user/{idUser}")
    private void dislikeGame(@PathVariable("idGame") int idGame, @PathVariable("idUser") int idUser) {
        management.dislikeGame(idUser, idGame);
    }

    //sport
    @PostMapping("/sport/{idSport}/user/{idUser}")
    private void likeSport(@PathVariable("idSport") int idSport, @PathVariable("idUser") int idUser) {
        management.likeSport(idUser, idSport);
    }

    @DeleteMapping("/sport/{idSport}/user/{idUser}")
    private void dislikeSport(@PathVariable("idSport") int idSport, @PathVariable("idUser") int idUser) {
        management.dislikeSport(idUser, idSport);
    }

    //curiosity
    @PostMapping("/curiosity/{idCuriosity}/user/{idUser}")
    private void likeCuriosity(@PathVariable("idCuriosity") int idCuriosity, @PathVariable("idUser") int idUser) {
        management.likeCuriosity(idUser, idCuriosity);
    }

    @DeleteMapping("/curiosity/{idCuriosity}/user/{idUser}")
    private void dislikeCuriosity(@PathVariable("idCuriosity") int idCuriosity, @PathVariable("idUser") int idUser) {
        management.dislikeCuriosity(idUser, idCuriosity);
    }

}
