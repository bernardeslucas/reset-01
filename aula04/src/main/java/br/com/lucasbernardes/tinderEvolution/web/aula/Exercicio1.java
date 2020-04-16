package br.com.lucasbernardes.tinderEvolution.web.aula;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ex1")
public class Exercicio1 {


    private static String nome = "Lucas";

    @GetMapping
    public String retornaNome() {

        return nome;
    }

    @PutMapping("/{nome}")
    public void atualizaNome(@PathVariable("nome") String nomeAtt) {
        nome = nomeAtt;
    }

    @DeleteMapping("/{nome}")
    public void deletarNome(@PathVariable("nome") String nomeDelete) {
        if (nome.equals(nomeDelete)) {
            nome = null;
        }
    }


}
