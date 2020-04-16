package br.com.lucasbernardes.tinderEvolution.web.aula;

import br.com.lucasbernardes.tinderEvolution.domain.InfoProjeto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/helloworld") // url base

public class HelloWorldRest {
    private static int contador = 1;
    private static List<InfoProjeto> lista = new ArrayList<>();


    @GetMapping //define verbo do metodo

    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/{nome}") //define verbo do metodo
    public String helloWorldParam(@PathVariable("nome") String nome) {
        return "Hello World, " + nome;
    }



}
